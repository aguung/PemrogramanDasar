package com.devfutech.pemrogramandasar

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.devfutech.pemrogramandasar.databinding.ActivityMainBinding
import com.devfutech.pemrogramandasar.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var doubleBackToExitPressedOnce = false
    private lateinit var navController: NavController
    private val mediaPlayer by lazy {
        MediaPlayer.create(this, R.raw.button)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupAction() {
        binding.btnHome.setOnClickListener {
            mediaPlayer.start()
            navController.navigate(R.id.action_global_homeFragment)
        }
        binding.btnBack.setOnClickListener {
            mediaPlayer.start()
            navController.navigateUp()
        }
    }

    private fun setupView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.splashScreenFragment ||
                destination.id == R.id.introFragment
            ) {
                toogleHeader(isShowingHeader = false)
            } else {
                toogleHeader(isShowingHeader = true)
            }
        }
    }

    private fun toogleHeader(isShowingHeader: Boolean) {
        binding.layoutHeader.isVisible = isShowingHeader
    }

    fun setHeaderTitle(title: String?) {
        binding.txtTitle.text = title
    }

    override fun onSupportNavigateUp(): Boolean {
        mediaPlayer.start()
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.label == resources.getString(R.string.home)
        ) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
            }
            this.doubleBackToExitPressedOnce = true
            toast("Tolon tekan lagi untuk keluar")
            Handler(Looper.getMainLooper()).postDelayed(
                { doubleBackToExitPressedOnce = false },
                2000
            )
        } else {
            navController.navigateUp()
        }
    }
}