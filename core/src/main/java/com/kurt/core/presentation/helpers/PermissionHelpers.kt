package com.kurt.core.presentation.helpers

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 09/04/2019
 */

fun Context.isPermissionGranted(vararg permissions: String): Boolean {
    permissions.forEach {
        if (ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}

fun Activity.needPermissions(permissions: Array<String>, requestCode: Int, action: () -> Unit) {
    if (!isPermissionGranted(*permissions)) {
        ActivityCompat.requestPermissions(this, permissions, requestCode)
    } else {
        action()
    }
}

fun Fragment.needPermissions(permissions: Array<String>, requestCode: Int, action: () -> Unit) {
    if (!this.requireActivity().isPermissionGranted(*permissions)) {
        requestPermissions(permissions, requestCode)
    } else {
        action()
    }
}
