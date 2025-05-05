package com.duylt.runningchecker.presentation.screen.tracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.duylt.runningchecker.R
import com.duylt.runningchecker.databinding.ScreenTrackingBinding
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingScreen: Fragment(R.layout.screen_tracking) {

    private lateinit var binding: ScreenTrackingBinding
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenTrackingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        asyncMap(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        binding.mapView.onResume()
    }

    override fun onStart() {
        super.onStart()

        binding.mapView.onStart()
    }

    override fun onPause() {
        binding.mapView.onPause()

        super.onPause()
    }

    override fun onStop() {
        binding.mapView.onStop()

        super.onStop()
    }

    @Deprecated("Deprecated in Java")
    override fun onLowMemory() {
        binding.mapView.onLowMemory()

        super.onLowMemory()
    }

    override fun onDestroy() {
        binding.mapView.onDestroy()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        binding.mapView.onSaveInstanceState(outState)
    }

    private fun asyncMap(bundle: Bundle?) {
        binding.mapView.apply {
            onCreate(bundle)
            getMapAsync { googleMap ->
                map = googleMap
            }
        }
    }

}