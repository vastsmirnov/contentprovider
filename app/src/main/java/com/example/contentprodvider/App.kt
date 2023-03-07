package com.example.contentprodvider

import android.app.Application
import com.example.contentprodvider.di.dataModule
import com.example.contentprodvider.di.domainModule
import com.example.contentprodvider.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(uiModule + domainModule + dataModule)
        }
    }
}