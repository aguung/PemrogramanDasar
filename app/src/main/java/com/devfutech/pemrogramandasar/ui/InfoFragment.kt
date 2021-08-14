package com.devfutech.pemrogramandasar.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devfutech.pemrogramandasar.MainActivity
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.databinding.InfoFragmentBinding
import com.devfutech.pemrogramandasar.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val binding:InfoFragmentBinding by lazy {
        InfoFragmentBinding.inflate(layoutInflater)
    }
    private val mediaPlayer by lazy {
        MediaPlayer.create(context, R.raw.button)
    }

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

    private fun setupAction() {
        binding.apply {
            btnInstagram.setOnClickListener {
                mediaPlayer.start()
                val uri: Uri = Uri.parse("http://instagram.com/_u/rosyid_fk")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)
                likeIng.setPackage("com.instagram.android")
                try {
                    startActivity(likeIng)
                } catch (e: ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/rosyid_fk")
                        )
                    )
                }
            }

            btnWhatsapp.setOnClickListener {
                mediaPlayer.start()
                val contact = "+628566666354"
                val message = "Halo pak"
                val url = "https://api.whatsapp.com/send?phone=$contact&text=${message}"
                try {
                    val pm = requireContext().packageManager
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
                    val i = Intent(Intent.ACTION_VIEW)
                    i.type = "text/plain"
                    val text = "YOUR TEXT HERE"
                    i.putExtra(Intent.EXTRA_TEXT,text)
                    i.data = Uri.parse(url)
                    startActivity(i)
                } catch (e: Exception) {
                    requireContext().toast("Error : ${e.message}")
                }
            }

            btnEmail.setOnClickListener {
                mediaPlayer.start()
                val email = Intent(Intent.ACTION_SEND)
                email.putExtra(Intent.EXTRA_EMAIL, arrayOf("fadhillahkhoirurrosyid@gmail.com"))
                email.putExtra(Intent.EXTRA_SUBJECT, "Pemrograman Dasar")
                email.type = "message/rfc822"
                startActivity(Intent.createChooser(email, "Choose an Email client :"))
            }
        }
    }

    private fun setupView() {
        (activity as MainActivity).setHeaderTitle("Info")
    }


}