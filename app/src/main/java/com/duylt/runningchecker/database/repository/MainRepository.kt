package com.duylt.runningchecker.database.repository

import androidx.lifecycle.LiveData
import com.duylt.runningchecker.database.dao.RunDao
import com.duylt.runningchecker.model.entity.RunEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val runDao: RunDao
) {

    suspend fun saveRecord(entity: RunEntity) {
        runDao.saveRecord(entity)
    }

    suspend fun deleteRecord(entity: RunEntity) {
        runDao.deleteRecord(entity)
    }

    fun getAllRecordsRunnerSortedByDate(): LiveData<List<RunEntity>> {
        return runDao.getAllRecordsRunnerSortedByDate()
    }

    fun getAllRecordsRunnerSortedByTimeInMillis(): LiveData<List<RunEntity>> {
        return runDao.getAllRecordsRunnerSortedByTimeInMillis()
    }

    fun getAllRecordsRunnerSortedByCaloriesBurned(): LiveData<List<RunEntity>> {
        return runDao.getAllRecordsRunnerSortedByCaloriesBurned()
    }

    fun getAllRecordsRunnerSortedByAvgSpeedInKmh(): LiveData<List<RunEntity>> {
        return runDao.getAllRecordsRunnerSortedByAvgSpeedInKmh()
    }

    fun getAllRecordsRunnerSortedByDistanceInMeters(): LiveData<List<RunEntity>> {
        return runDao.getAllRecordsRunnerSortedByDistanceInMeters()
    }

    fun getTotalTimeInMillis(): LiveData<Long> {
        return runDao.getTotalTimeInMillis()
    }

    fun getTotalCaloriesBurned(): LiveData<Int> {
        return runDao.getTotalCaloriesBurned()
    }

    fun getTotalDistanceInMeters(): LiveData<Int> {
        return runDao.getTotalDistanceInMeters()
    }

    fun getAvgSpeed(): LiveData<Float> {
        return runDao.getAvgSpeed()
    }

}