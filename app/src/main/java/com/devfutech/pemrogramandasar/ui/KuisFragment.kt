package com.devfutech.pemrogramandasar.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devfutech.pemrogramandasar.MainActivity
import com.devfutech.pemrogramandasar.databinding.KuisFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KuisFragment : Fragment() {

    private val binding: KuisFragmentBinding by lazy {
        KuisFragmentBinding.inflate(layoutInflater)
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
            btnKuisSatu.setOnClickListener {
                openBrowser("https://docs.google.com/forms/d/e/1FAIpQLSc50cCliTgVCjxof9___QeSxNocspN-wHid7uz8dcXBsWveQQ/viewform?usp=sf_link")
            }
            btnKuisDua.setOnClickListener {
                openBrowser("https://docs.google.com/forms/d/e/1FAIpQLScUA-wILsHJM-8aI70gWoPkxXZgGxWLM98guf5QC11C5FEUxg/viewform?usp=sf_link")
            }
        }
    }

    private fun openBrowser(link: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }

    private fun setupView() {
        (activity as MainActivity).setHeaderTitle("Kuis")
    }
}