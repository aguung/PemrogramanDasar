package com.devfutech.pemrogramandasar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.devfutech.pemrogramandasar.MainActivity
import com.devfutech.pemrogramandasar.adapter.ContentMateriAdapter
import com.devfutech.pemrogramandasar.data.model.Content
import com.devfutech.pemrogramandasar.databinding.ContentMateriFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentMateriFragment : Fragment() {

    private val binding: ContentMateriFragmentBinding by lazy {
        ContentMateriFragmentBinding.inflate(layoutInflater)
    }
    private val args: ContentMateriFragmentArgs by navArgs()

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
        (activity as MainActivity).setHeaderTitle(args.subMateri.nama)
        val contentMateriAdapter = ContentMateriAdapter(
            this::onItemAlurClick,
            this::onItemContentClick,
            args.subMateri.type
        )
        binding.apply {
            rvContent.apply {
                adapter = contentMateriAdapter
                layoutManager = LinearLayoutManager(activity)
                setHasFixedSize(true)
            }
        }
        contentMateriAdapter.submitList(args.subMateri.content)
    }

    private fun onItemAlurClick(item: Content) {
        findNavController().navigate(
            ContentMateriFragmentDirections.actionContentMateriFragmentToBottomDialogFragment(
                content = item
            )
        )
    }

    private fun onItemContentClick(video: String?) {
        findNavController().navigate(
            ContentMateriFragmentDirections.actionContentMateriFragmentToBottomDialogFragment(
                video = video
            )
        )
    }

}