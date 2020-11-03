package com.suraj.mobilemouse.senders

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothHidDevice
import android.util.Log
import com.suraj.mobilemouse.reports.MouseReport
import java.util.*
import kotlin.concurrent.schedule

@Suppress("MemberVisibilityCanBePrivate")
open class Sender(
    val hidDevice: BluetoothHidDevice,
    val host: BluetoothDevice
) {
    protected val mouseReport = MouseReport()

    protected open fun sendMouse() {
        Log.i("Sender", "sendMouse")
        if( !hidDevice.sendReport(host, MouseReport.ID, mouseReport.bytes) ) {
            Log.e(TAG, "Report wasn't sent")
        }
    }

    fun sendTestMouseMove() {
        Log.i("Sender", "sendTestMouseMove")
        mouseReport.dx = 20
        mouseReport.dy = 20
        sendMouse()
    }

    fun sendTestClick() {
        Log.i("Sender", "sendTestClick")
        mouseReport.leftButton = true
        sendMouse()
        Timer().schedule(150L) {
            mouseReport.leftButton = false
            sendMouse()
        }
    }

    companion object {
        const val TAG = "Sender"
    }

}