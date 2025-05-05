package com.duylt.runningchecker.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.duylt.runningchecker.model.entity.RunEntity

@Dao
interface RunDao {

    @Insert(entity = RunEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecord(entity: RunEntity)

    @Delete
    suspend fun deleteRecord(entity: RunEntity)

    @Query("SELECT * FROM RECORD_RUNNER_ENTITY ORDER BY timeStamp DESC")
    fun getAllRecordsRunnerSortedByDate(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM RECORD_RUNNER_ENTITY ORDER BY timeInMillis DESC")
    fun getAllRecordsRunnerSortedByTimeInMillis(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM RECORD_RUNNER_ENTITY ORDER BY caloriesBurned DESC")
    fun getAllRecordsRunnerSortedByCaloriesBurned(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM RECORD_RUNNER_ENTITY ORDER BY avgSpeedInKmh DESC")
    fun getAllRecordsRunnerSortedByAvgSpeedInKmh(): LiveData<List<RunEntity>>

    @Query("SELECT * FROM RECORD_RUNNER_ENTITY ORDER BY distanceInMeters DESC")
    fun getAllRecordsRunnerSortedByDistanceInMeters(): LiveData<List<RunEntity>>

    @Query("SELECT SUM(`timeInMillis`) FROM RECORD_RUNNER_ENTITY")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(`caloriesBurned`) FROM RECORD_RUNNER_ENTITY")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(`distanceInMeters`) FROM RECORD_RUNNER_ENTITY")
    fun getTotalDistanceInMeters(): LiveData<Int>

    @Query("SELECT AVG(`avgSpeedInKmh`) FROM RECORD_RUNNER_ENTITY")
    fun getAvgSpeed(): LiveData<Float>
}