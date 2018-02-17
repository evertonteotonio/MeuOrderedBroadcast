package com.example.logonrm.demoorderedbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)


        /*
        btnEnviar.setOnClickListener({
            sendBroadcast(Intent("MeuOrdereadBroadcast"))
        })
        */

        btnEnviar.setOnClickListener {
            sendBroadcast(Intent("com.example.logonrm.demoorderedbroadcast.MeuOutroRceiver"))
        }


        ///////

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action.equals(Intent.ACTION_POWER_CONNECTED)){
                }else{
                    tvUSBstatus.text = "Cabo conectado"
                }
                tvUSBstatus.text = "Cabo desconectado"
            }
        }

        /*
        when(intent?.action){
            Intent.ACTION_POWER_CONNECTED -> tvUSBstatus.text = "Cabo conectado"
            Intent.ACTION_POWER_DISCONNECTED -> tvUSBstatus.text = "Cabo desconectado"
        }
        */

        registerReceiver(receiver, filter)


    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }



}
