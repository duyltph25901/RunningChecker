package com.duylt.runningchecker.presentation.screen.statistics

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.duylt.runningchecker.R
import com.duylt.runningchecker.model.view_model.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticScreen: Fragment(R.layout.screen_statistics) {
    private val viewModel: StatisticsViewModel by activityViewModels()

}