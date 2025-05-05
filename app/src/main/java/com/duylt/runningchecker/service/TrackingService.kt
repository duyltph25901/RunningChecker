package com.duylt.runningchecker.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.duylt.runningchecker.R
import com.duylt.runningchecker.commons.AppConst.ACTION_PAUSE_SERVICE
import com.duylt.runningchecker.commons.AppConst.ACTION_SHOW_TRACKING_SCREEN
import com.duylt.runningchecker.commons.AppConst.ACTION_START_OR_RESUME_SERVICE
import com.duylt.runningchecker.commons.AppConst.NOTIFICATION_CHANNEL_ID
import com.duylt.runningchecker.commons.AppConst.NOTIFICATION_CHANNEL_NAME
import com.duylt.runningchecker.commons.AppConst.NOTIFICATION_ID
import com.duylt.runningchecker.presentation.screen.MainScreen

class TrackingService : LifecycleService() {

    private var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun) {
                        startForegroundService()
                        isFirstRun = false
                    }
                    Log.d("duylt", "ACTION_START_OR_RESUME_SERVICE")
                }

                ACTION_PAUSE_SERVICE -> {
                    Log.d("duylt", "ACTION_PAUSE_SERVICE")
                }

                else -> {
                    Log.d("duylt", "ACTION_STOP_SERVICE")
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForegroundService() {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChanel(notificationManager)
        }

        val notificationBuilder =
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID).setAutoCancel(false)
                .setOngoing(true).setSmallIcon(R.drawable.ic_run).setContentTitle("Running App")
                .setContentText("00:00:00").setContentIntent(getMainScreenPendingIntent())

        startForeground(NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun getMainScreenPendingIntent(): PendingIntent {
        val intent = Intent(this, MainScreen::class.java).apply {
            action = ACTION_SHOW_TRACKING_SCREEN
        }

        val flags = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        } else {
            FLAG_UPDATE_CURRENT
        }

        return PendingIntent.getActivity(this, 0, intent, flags)
    }


    private fun createNotificationChanel(notificationManager: NotificationManager) {
        val chanel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, IMPORTANCE_HIGH
        )

        notificationManager.createNotificationChannel(chanel)
    }
}