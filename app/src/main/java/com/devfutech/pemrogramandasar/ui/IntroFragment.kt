package com.devfutech.pemrogramandasar.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.data.local.AppPreferences
import com.devfutech.pemrogramandasar.databinding.IntroFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class IntroFragment : Fragment() {

    private val binding: IntroFragmentBinding by lazy {
        IntroFragmentBinding.inflate(layoutInflater)
    }
    private val mediaPlayer by lazy {
        MediaPlayer.create(context, R.raw.button)
    }

    @Inject
    lateinit var appPreferences: AppPreferences

    private val content = listOf(
        listOf(
            "Media Pembelajaran Pemograman Dasar",
            "Tujuan",
            "Sasaran",
            "Pencapaian",
        ),
        listOf(
            R.drawable.icon_splash,
            R.drawable.icon_tujuan,
            R.drawable.icon_sasaran,
            R.drawable.icon_pencapaian,
        ),
        listOf(
            "Media belajar siswa Sekolah Menengah Kejuruan pada mata pelajaran Pemrograman Dasar.",
            "Membantu meningkatkan motivasi belajar dan pemahaman siswa dalam materi Pemrograman Dasar secara mandiri.",
            "Siswa mampu memahami dasar-dasar pemrograman seperti algoritma pemrograman, bahasa pemrograman, tipe data, variable, konstanta dan operator dalam pemrograman.",
            "Pengelompokan menu berdasarkan topic bahasan memudahkan siswa dalam belajar, dilengkapi dengan video pembelajaran yang akan meningkatkan pemahaman siswa dalam pembahasan materi. Dilengkapi juga dengan Quiz sebagai laman evaluasi belajar siswa.",
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupAction()
    }

    private fun setupUI() {
        val pagerAdapter = ScreenSlidePagerAdapter(this, content, binding)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.setPageTransformer(DepthPageTransformer())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()
    }

    private fun setupAction() {
        binding.apply {
            btnSkip.setOnClickListener {
                mediaPlayer.start()
                if (btnSkip.text.trim().toString() == resources.getString(R.string.lewati)) {
                    onBoardingFinished()
                } else {
                    viewPager.currentItem++
                }
            }
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab?.position == content.size) {
                        binding.btnSkip.text =
                            binding.root.context.resources.getString(R.string.lewati)
                    } else {
                        binding.btnSkip.text =
                            binding.root.context.resources.getString(R.string.selanjutnya)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }
    }

    private fun onBoardingFinished() {
        lifecycleScope.launchWhenStarted {
            appPreferences.saveIntro(true)
            findNavController().navigate(R.id.action_introFragment_to_homeFragment)
        }
    }

    class ScreenSlidePagerAdapter(
        fragment: Fragment,
        val content: List<List<Any>>,
        val binding: IntroFragmentBinding
    ) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = content[0].size

        override fun createFragment(position: Int): Fragment {
            val fragment = ContentIntroFragment()
            fragment.arguments = Bundle().apply {
                putString(ContentIntroFragment.TITLE, content[0][position].toString())
                putInt(ContentIntroFragment.IMAGE, content[1][position] as Int)
                putString(ContentIntroFragment.DESCRIPTION, content[2][position].toString())
            }
            return fragment
        }
    }


    class DepthPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                when {
                    position < -1 -> {
                        alpha = 0f
                    }
                    position <= 0 -> {
                        alpha = 1f
                        translationX = 0f
                        translationZ = 0f
                        scaleX = 1f
                        scaleY = 1f
                    }
                    position <= 1 -> {
                        alpha = 1 - position
                        translationX = pageWidth * -position
                        translationZ = -1f
                        val scaleFactor = (0.75f + (1 - 0.75f) * (1 - abs(position)))
                        scaleX = scaleFactor
                        scaleY = scaleFactor
                    }
                    else -> {
                        alpha = 0f
                    }
                }
            }
        }
    }

}