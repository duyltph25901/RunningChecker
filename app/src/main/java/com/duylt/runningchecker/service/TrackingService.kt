package com.duylt.runningchecker.service

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.duylt.runningchecker.commons.AppConst.ACTION_PAUSE_SERVICE
import com.duylt.runningchecker.commons.AppConst.ACTION_START_OR_RESUME_SERVICE
import com.duylt.runningchecker.commons.AppConst.ACTION_STOP_SERVICE

class TrackingService : LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
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

}