package com.example.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val androidApplication = application as AndroidApplication
        (androidApplication).appComponent.inject(this)

        Log.d("MainActivity","retrofit 1 baseUrl : ${retrofit.baseUrl()}")

        androidApplication.appComponent2 = DaggerApplicationComponent.builder().apiModule(ApiModule("https://www.google.com")).build()
        (androidApplication).appComponent2.inject(this)

        Log.d("MainActivity","retrofit 2 baseUrl : ${retrofit.baseUrl()}")

        print(retrofit)
    }
}