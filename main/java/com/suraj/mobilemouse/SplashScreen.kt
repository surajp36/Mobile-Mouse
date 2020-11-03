package com.suraj.mobilemouse

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.startActivity

class SplashScreen: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SplashScreen:", "onCreate..." )
        super.onCreate(savedInstanceState)
        if( checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            requestPermissions( arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 0 )
        } else {
            startActivity<SelectDeviceActivity>()
            finish()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Log.i("SplashScreen:", "onRequestPermissionsResult..." )
        if( grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {
            startActivity<SelectDeviceActivity>()
        }
        finish()
    }

}