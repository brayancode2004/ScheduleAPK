package com.uam.scheduleapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.uam.scheduleapk.compose.LoginCompose
import com.uam.scheduleapk.ui.theme.ScheduleApkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScheduleApkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginCompose(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

