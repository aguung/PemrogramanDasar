package com.devfutech.pemrogramandasar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devfutech.pemrogramandasar.databinding.ContentIntroFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentIntroFragment : Fragment() {

    private val binding: ContentIntroFragmentBinding by lazy {
        ContentIntroFragmentBinding.inflate(layoutInflater)
    }

    companion object {
        const val TITLE = "TITLE"
        const val IMAGE = "IMAGE"
        const val DESCRIPTION = "DESCRIPTION"
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
    }

    private fun setupView() {
        arguments?.takeIf { it.containsKey("TITLE") }?.apply {
            binding.txtContent.text = getString(TITLE)
            binding.imgContent.setImageResource(getInt(IMAGE))
            binding.txtDescription.text = getString(DESCRIPTION)
        }
    }

}