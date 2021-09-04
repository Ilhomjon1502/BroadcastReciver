package com.example.brodcastresiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    private val TAG = "MyReceiver"
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onResive : Jring...")
        Toast.makeText(context, "Jring...", Toast.LENGTH_SHORT).show()
    }
}