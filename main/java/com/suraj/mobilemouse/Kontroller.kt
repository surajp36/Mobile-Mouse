package com.suraj.mobilemouse

import android.app.Application
import android.util.Log

@Suppress("unused") // It's in manifest -_-
class Kontroller : Application() {
    override fun onCreate() {
        Log.i("Mobile_Mouse:", "Mobile_Mouse::onCreate..." )
        super.onCreate()
    }
}