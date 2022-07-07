package com.android254.droidconKE2022

import android.app.Application
import com.android254.droidconKE2022.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class DroidconKE2022 : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DroidconKE2022)
            modules(AppModule().module)
        }
    }
}
