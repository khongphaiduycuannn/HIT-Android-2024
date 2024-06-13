package com.example.buoi13

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        private lateinit var context: Context

        fun getContext() = context
    }
}