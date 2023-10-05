package org.acad.whatsup.app

import android.app.Application
import org.acad.whatsup.di.appModule
import org.acad.whatsup.di.localModule
import org.acad.whatsup.di.remoteModule
import org.acad.whatsup.di.repoModule
import org.acad.whatsup.di.useCaseModule
import org.acad.whatsup.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Acad Bek on 10/5/2023.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                repoModule,
                useCaseModule,
                localModule,
                remoteModule,
                viewModelModule
            )
        }
    }
}