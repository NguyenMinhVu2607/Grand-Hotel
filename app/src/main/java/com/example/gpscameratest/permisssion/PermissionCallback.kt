package com.example.gpscameratest.permisssion

interface PermissionCallback {
    fun onPermissionGranted()
    fun onPermissionDenied(deniedPermissions: List<String>)
}