package com.example.logonrm.demoorderedbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by logonrm on 17/02/2018.
 */
class MeuOutroRceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("DEMOORDERED", "Meu outro receiver")
    }
}