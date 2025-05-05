package com.duylt.runningchecker.presentation.screen.run

import  androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.duylt.runningchecker.R
import com.duylt.runningchecker.model.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunScreen: Fragment(R.layout.screen_run) {

    private val viewModel: MainViewModel by activityViewModels()

}