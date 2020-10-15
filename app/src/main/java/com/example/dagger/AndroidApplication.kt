package com.example.dagger

import android.app.Application
import dagger.Component
import dagger.android.DaggerApplication

class AndroidApplication : Application()
{

    lateinit var appComponent: ApplicationComponent

    lateinit var appComponent2: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder().apiModule(ApiModule("https://jsonplaceholder.typicode.com")).build()
    }
}