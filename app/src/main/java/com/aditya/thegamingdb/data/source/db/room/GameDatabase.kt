package com.aditya.thegamingdb.data.source.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aditya.thegamingdb.data.source.db.entity.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}