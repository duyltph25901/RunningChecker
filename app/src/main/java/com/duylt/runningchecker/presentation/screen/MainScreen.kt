package com.duylt.runningchecker.presentation.screen

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.duylt.runningchecker.R
import com.duylt.runningchecker.commons.AppConst.ACTION_SHOW_TRACKING_SCREEN
import com.duylt.runningchecker.databinding.ScreenMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : AppCompatActivity() {

    private lateinit var binding: ScreenMainBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ScreenMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment

        navigateToTrackingScreen(intent)

        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.settingScreen, R.id.runScreen, R.id.statisticScreen -> showBottomBar()
                else -> hideBottomBar()
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        navigateToTrackingScreen(intent)
    }

    private fun showBottomBar() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomBar() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    private fun navigateToTrackingScreen(intent: Intent?) {
        intent?.let {
            if (it.action == ACTION_SHOW_TRACKING_SCREEN) {
                navHostFragment.findNavController().navigate(R.id.action_global_trackingScreen)
            }
        }
    }
}