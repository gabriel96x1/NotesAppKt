package com.another.appmvvm.app

import android.app.Application
import androidx.work.Configuration
import com.another.appmvvm.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(if (BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
            .build()
}