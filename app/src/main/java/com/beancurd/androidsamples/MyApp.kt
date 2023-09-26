package com.beancurd.androidsamples

import android.app.Application
import android.util.Log

/**
 *
 *
 * @author  on 2023/9/25
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("dirk", "app oncreate ... ")
    }
}