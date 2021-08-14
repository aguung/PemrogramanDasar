package com.devfutech.pemrogramandasar.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.databinding.FragmentBottomDialogBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BottomDialogFragment : DialogFragment() {
    private val binding: FragmentBottomDialogBinding by lazy {
        FragmentBottomDialogBinding.inflate(layoutInflater)
    }

    private val args by navArgs<BottomDialogFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private val images = listOf("contoh", "hasil","konstanta","variable","operator")

    override fun getTheme(): Int = R.style.DialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        Dialog(requireContext(), theme)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            videoContent.isVisible = (args.video != null)
            if (args.content != null) {
                txtContent.text = args.content?.content
                imageContent.setImageResource(args.content?.image!!)
            }
            if (args.video != null) {
                val resource = mapContenVideo(args.video!!)
                videoContent.isVisible = (images.find { it == args.video } == null)
                if (images.find { it == args.video } != null) {
                    imageContent.setImageResource(resource)
                } else {
                    showVideo(resource)
                }
            }
        }
    }

    private fun showVideo(video: Int) {
        binding.apply {
            videoContent.setVideoPath("android.resource://" + requireActivity().packageName + "/" + video)
            videoContent.setOnPreparedListener { mp ->
                mp.isLooping = true
                videoContent.start()
            }
        }
    }

    private fun mapContenVideo(video: String): Int {
        return when (video) {
            "konsep" -> R.raw.konsep
            "flowchart" -> R.raw.flowchart
            "natural" -> R.raw.natural
            "pseudoce" -> R.raw.pseudoce
            "percabangan" -> R.raw.percabangan
            "perulangan" -> R.raw.perulangan
            "sekuensial" -> R.raw.sekuensial
            "contoh" -> R.drawable.contoh
            "hasil" -> R.drawable.hasil
            "variable" -> R.drawable.variable
            "konstanta" -> R.drawable.konstanta
            "operator" -> R.drawable.operator
            else -> R.raw.button
        }
    }
}
