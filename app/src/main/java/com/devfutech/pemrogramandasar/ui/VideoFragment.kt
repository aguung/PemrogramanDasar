package com.devfutech.pemrogramandasar.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devfutech.pemrogramandasar.MainActivity
import com.devfutech.pemrogramandasar.databinding.VideoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class VideoFragment : Fragment() {

    private val binding: VideoFragmentBinding by lazy {
        VideoFragmentBinding.inflate(layoutInflater)
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
            btnPengantar.setOnClickListener {
                openBrowser("https://youtu.be/nRxQQPo7ahE")
            }
            btnDeskriptif.setOnClickListener {
                openBrowser("https://youtu.be/4XEVbvHTkcQ")
            }
            btnFlowchart.setOnClickListener {
                openBrowser("https://youtu.be/N9cPu3LjKY0")
            }
            btnPseudocode.setOnClickListener {
                openBrowser("https://youtu.be/JcedBtAH5y8")
            }
            btnVariable.setOnClickListener {
                openBrowser("https://youtu.be/gtzxt8bYn7E")
            }
            btnTipe.setOnClickListener {
                openBrowser("https://youtu.be/fCuajrJAbYY")
            }
            btnOperator.setOnClickListener {
                openBrowser("https://youtu.be/fKmukX93lkM")
            }
        }
    }

    private fun openBrowser(link: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }

    private fun setupView() {
        (activity as MainActivity).setHeaderTitle("Video")
    }
}