package com.duylt.runningchecker.di

import android.content.Context
import androidx.room.Room
import com.duylt.runningchecker.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        name = "AppDatabase.db"
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(appDb: AppDatabase) =
        appDb.runDao()

}