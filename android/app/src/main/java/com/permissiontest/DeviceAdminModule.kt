package com.permissiontest

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class DeviceAdminModule(private val reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "DeviceAdminModule"
    }

    @ReactMethod
    fun requestAdmin() {

        val activity = reactContext.currentActivity ?: return

        val componentName = ComponentName(activity, MyDeviceAdminReceiver::class.java)

        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
            putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName)
            putExtra(
                DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "This app requires device admin permission."
            )
        }

        activity.startActivity(intent)
    }
}