package com.devfutech.pemrogramandasar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devfutech.pemrogramandasar.MainActivity
import com.devfutech.pemrogramandasar.databinding.PustakaFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PustakaFragment : Fragment() {

    private val binding:PustakaFragmentBinding by lazy {
        PustakaFragmentBinding.inflate(layoutInflater)
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
        (activity as MainActivity).setHeaderTitle("Pustaka")
    }

}