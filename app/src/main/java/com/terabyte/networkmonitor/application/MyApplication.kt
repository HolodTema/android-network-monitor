package com.terabyte.networkmonitor.application

import android.app.Application
import com.terabyte.networkmonitor.di.component.AppComponent
import com.terabyte.networkmonitor.di.component.DaggerAppComponent

class MyApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}