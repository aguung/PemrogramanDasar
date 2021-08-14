package com.devfutech.pemrogramandasar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devfutech.pemrogramandasar.adapter.SubMateriAdapter
import com.devfutech.pemrogramandasar.data.model.Materi
import com.devfutech.pemrogramandasar.data.model.SubMateri
import com.devfutech.pemrogramandasar.databinding.SubMateriFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubMateriFragment : Fragment() {

    companion object {
        const val ITEM = "materi_item"
    }

    private val binding: SubMateriFragmentBinding by lazy {
        SubMateriFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ITEM) }?.apply {
            val data: Materi? = getParcelable(ITEM)
            setupView(data)
        }
    }

    private fun setupView(data: Materi?) {
        val subMateriAdapter = SubMateriAdapter(this@SubMateriFragment::onClickEvent)
        binding.apply {
            rvMateri.apply {
                adapter = subMateriAdapter
                layoutManager = LinearLayoutManager(activity)
                setHasFixedSize(true)
            }
        }
        subMateriAdapter.submitList(data?.subMateri)
    }

    private fun onClickEvent(subMateri: SubMateri) {
        findNavController().navigate(
            MateriFragmentDirections.actionMateriFragmentToContentMateriFragment(
                subMateri = subMateri
            )
        )
    }

}