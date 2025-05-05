package com.duylt.runningchecker.model.view_model

import androidx.lifecycle.ViewModel
import com.duylt.runningchecker.database.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val mainRepo: MainRepository
): ViewModel() {
}