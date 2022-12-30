package com.aditya.thegamingdb.application

import android.app.Application
import com.aditya.thegamingdb.di.dataModule
import com.aditya.thegamingdb.di.databaseModule
import com.aditya.thegamingdb.di.mapperModule
import com.aditya.thegamingdb.di.networkModule
import com.aditya.thegamingdb.di.repositoryModule
import com.aditya.thegamingdb.di.usecaseModule
import com.aditya.thegamingdb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TheGamingDbApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@TheGamingDbApp)
            modules(
                mapperModule,
                dataModule,
                databaseModule,
                networkModule,
                repositoryModule,
                usecaseModule,
                viewModelModule
            )
        }
    }
}