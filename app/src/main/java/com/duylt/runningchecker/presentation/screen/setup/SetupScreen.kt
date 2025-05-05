package com.duylt.runningchecker.presentation.screen.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.duylt.runningchecker.R
import com.duylt.runningchecker.databinding.ScreenSetupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetupScreen: Fragment(R.layout.screen_setup) {

    private lateinit var binding: ScreenSetupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScreenSetupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickViews()
    }

    private fun clickViews() = binding.apply {
        tvContinue.setOnClickListener {
            findNavController().navigate(R.id.action_setupScreen_to_runScreen)
        }
    }

}