package com.aditya.thegamingdb.di

import androidx.room.Room
import com.aditya.thegamingdb.data.source.db.room.GameDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<GameDatabase>().gameDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("gamingdb".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            GameDatabase::class.java, "gameapp.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}