package com.example.brodcastresiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.brodcastresiver.Utils.NetworkHelper

class MyBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val networkHelper = NetworkHelper(p0!!)
        if (networkHelper.isNetworkConnected()) {
            Toast.makeText(p0, "Connected...", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(p0, "Disconnected...", Toast.LENGTH_SHORT).show()
        }
    }
}