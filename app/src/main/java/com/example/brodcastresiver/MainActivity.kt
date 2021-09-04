package com.example.brodcastresiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.brodcastresiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myBroadcastReceiver: MyBroadcastReceiver

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myBroadcastReceiver= MyBroadcastReceiver()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(myBroadcastReceiver, intentFilter)

        binding.btnAlarm.setOnClickListener {
            val time = SystemClock.elapsedRealtime() + 1000
            val intent = Intent(this, MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, time, 10000, pendingIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }
}