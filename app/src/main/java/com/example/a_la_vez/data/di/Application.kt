package com.example.a_la_vez.data.di

import android.app.Application
import com.example.a_la_vez.data.di.module.registerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    registerModule

                )
            )
        }
    }
}