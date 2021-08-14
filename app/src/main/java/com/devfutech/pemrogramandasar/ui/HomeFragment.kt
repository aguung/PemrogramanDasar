package com.devfutech.pemrogramandasar.ui

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.data.local.AppPreferences
import com.devfutech.pemrogramandasar.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.managers.ViewComponentManager
import kotlinx.coroutines.flow.collectLatest
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val binding: HomeFragmentBinding by lazy {
        HomeFragmentBinding.inflate(layoutInflater)
    }
    private val mediaPlayer by lazy {
        MediaPlayer.create(context, R.raw.button)
    }

    @Inject
    lateinit var appPreferences: AppPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupAction()
    }

    private fun setupView() {
        lifecycleScope.launchWhenStarted {
            appPreferences.guideHome.collectLatest { guideHome ->
                if (!guideHome) {
                    setGuideDate(
                        view = binding.btnKikd,
                        posisi = 0,
                        title = "Kompetensi Inti dan Kompetensi Dasar",
                        description = "Menu ini digunakan untuk menampilkan target pencapaian dari materi yang akan disampaikan"
                    )
                }
            }
        }
    }

    private fun activityContext(): Context? {
        val context = binding.root.context
        return if (context is ViewComponentManager.FragmentContextWrapper) {
            context.baseContext
        } else context
    }

    private fun setGuideDate(view: View, posisi: Int, title: String, description: String) {
        GuideView.Builder(activityContext())
            .setTitle(title)
            .setContentText(description)
            .setContentTextSize(12)
            .setTitleTextSize(14)
            .setGravity(Gravity.center)
            .setTargetView(view)
            .setDismissType(DismissType.anywhere)
            .setGuideListener {
                when (posisi) {
                    0 -> setGuideDate(
                        view = binding.btnMateri,
                        posisi = 1,
                        title = "Materi",
                        description = "Menu ini digunakan untuk menampilkan materi-materi yang akan disampaikan"
                    )
                    1 -> setGuideDate(
                        view = binding.btnVideo,
                        posisi = 2,
                        title = "Video",
                        description = "Menu ini digunakan untuk menampilkan video sebagai penunjang materi yang telah disampaikan"
                    )
                    2 -> setGuideDate(
                        view = binding.btnQuiz,
                        posisi = 3,
                        title = "Kuis",
                        description = "Menu ini digunakan untuk mengevaluasi hasil pembelejaran yang telah dipelajari"
                    )
                    3 -> setGuideDate(
                        view = binding.btnPustaka,
                        posisi = 4,
                        title = "Pustaka",
                        description = "Menu ini digunakan untuk menampilkan sumber bahan ajar yang dalam materi yang telah disampaikan"
                    )
                    4 -> setGuideDate(
                        view = binding.btnInfo,
                        posisi = 5,
                        title = "Info",
                        description = "Menu ini digunakan untuk menampilkan info dari pengembang aplikasi"
                    )
                    else -> lifecycleScope.launchWhenStarted { appPreferences.saveGuideHome(true) }
                }
            }
            .build()
            .show()
    }

    private fun setupAction() {
        binding.apply {
            btnKikd.setOnClickListener {
                mediaPlayer.start()
                findNavController().navigate(R.id.action_homeFragment_to_KIKDFragment)
            }
            btnMateri.setOnClickListener {
                mediaPlayer.start()
                findNavController().navigate(R.id.action_homeFragment_to_materiFragment)
            }
            btnVideo.setOnClickListener {
                mediaPlayer.start()
                findNavController().navigate(R.id.action_homeFragment_to_videoFragment)
            }
            btnQuiz.setOnClickListener {
                mediaPlayer.start()
                findNavController().navigate(R.id.action_homeFragment_to_kuisFragment)
            }
            btnPustaka.setOnClickListener {
                mediaPlayer.start()
                findNavController().navigate(R.id.action_homeFragment_to_pustakaFragment)
            }
            btnInfo.setOnClickListener {
                mediaPlayer.start()
                findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
            }
        }
    }

}