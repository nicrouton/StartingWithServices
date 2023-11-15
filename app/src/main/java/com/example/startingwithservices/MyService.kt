package com.example.startingwithservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {
    private var countdownValue = 0;

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            countdownValue = intent.getIntExtra("key", 0)
        }
        val scope = CoroutineScope(Dispatchers.Main)

        scope.launch{
            countDownTimer(countdownValue)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }





}

suspend fun countDownTimer(userNum: Int) {
    Log.e("countDownTimer","got here! " +
            "$userNum")
    repeat(userNum) {
        Log.d("Countdown", (userNum - it).toString())
        delay(1000)
    }

}

