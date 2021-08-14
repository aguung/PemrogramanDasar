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
                openBrowser("https://youtu.be/60K7zxIjHQo")
            }
            btnDeskriptif.setOnClickListener {
                openBrowser("https://youtu.be/I-pbjWd9EHo")
            }
            btnFlowchart.setOnClickListener {
                openBrowser("https://youtu.be/u1huXRBkSbE")
            }
            btnPseudocode.setOnClickListener {
                openBrowser("https://youtu.be/zqhQMGjNCmw")
            }
            btnVariable.setOnClickListener {
                openBrowser("https://youtu.be/oPaK-QQ3Ho4")
            }
            btnTipe.setOnClickListener {
                openBrowser("https://youtu.be/xY3HF99wHtg")
            }
            btnOperator.setOnClickListener {
                openBrowser("https://youtu.be/pe3VxboDe2U")
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