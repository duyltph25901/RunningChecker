package com.duylt.runningchecker.model.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RECORD_RUNNER_ENTITY")
data class RunEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var img: Bitmap? = null,
    var timeStamp: Long = System.currentTimeMillis(),
    var avgSpeedInKmh: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0,
) {
}