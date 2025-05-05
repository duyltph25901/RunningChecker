package com.duylt.runningchecker.presentation.screen.run

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.duylt.runningchecker.R
import com.duylt.runningchecker.commons.AppConst.REQUEST_CODE_PERMISSION
import com.duylt.runningchecker.commons.TrackingUtility.hasLocationPermission
import com.duylt.runningchecker.databinding.ScreenRunBinding
import com.duylt.runningchecker.model.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class RunScreen: Fragment(R.layout.screen_run), EasyPermissions.PermissionCallbacks {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: ScreenRunBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenRunBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestPermissionIfNotAllowed()
        onClickViews()
    }

    private fun onClickViews() = binding.apply {
        fab.setOnClickListener { findNavController().navigate(R.id.action_runScreen_to_trackingScreen) }
    }

    private fun requestPermissionIfNotAllowed() {
        if (!hasLocationPermission(requireContext())) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                EasyPermissions.requestPermissions(
                    this,
                    "You need to accept location permission to use this app.",
                    REQUEST_CODE_PERMISSION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                )
            } else {
                EasyPermissions.requestPermissions(
                    this,
                    "You need to accept location permission to use this app.",
                    REQUEST_CODE_PERMISSION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                )
            }
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else requestPermissionIfNotAllowed()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) = Unit

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

}