package com.duylt.runningchecker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.duylt.runningchecker.database.converters.Converters
import com.duylt.runningchecker.database.dao.RunDao
import com.duylt.runningchecker.model.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun runDao(): RunDao

}