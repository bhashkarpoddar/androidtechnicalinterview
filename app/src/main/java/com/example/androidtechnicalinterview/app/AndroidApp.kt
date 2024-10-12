package com.example.androidtechnicalinterview.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApp: Application() {

    override fun onCreate() {
        super.onCreate()

    }
}