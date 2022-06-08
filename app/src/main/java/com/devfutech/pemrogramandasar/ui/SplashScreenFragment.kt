package com.devfutech.pemrogramandasar.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.data.local.AppPreferences
import com.devfutech.pemrogramandasar.databinding.SplashScreenFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenFragment : Fragment() {

    private val binding: SplashScreenFragmentBinding by lazy {
        SplashScreenFragmentBinding.inflate(layoutInflater)
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
        setupAction()
    }

    private fun setupAction() {
        Handler(Looper.getMainLooper()).postDelayed({
            appPreferences.intro.asLiveData().observe(viewLifecycleOwner) { intro ->
                if (intro) {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
                } else {
                    findNavController().navigate(R.id.action_splashScreenFragment_to_introFragment)
                }
            }
        }, 3000L)
    }

}