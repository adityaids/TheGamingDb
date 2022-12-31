package com.aditya.thegamingdb.data.source.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM Game WHERE latest = 1")
    fun getLatestGame(): Flow<List<GameEntity>>

    @Query("SELECT * FROM Game WHERE rating > 4.0")
    fun getPopularGame(): Flow<List<GameEntity>>

    @Query("SELECT * FROM Game WHERE isFavorite = 1")
    fun getAllFavorite(): Flow<List<GameEntity>>

    @Query("SELECT * FROM Game WHERE name LIKE '%' || :name || '%' ")
    fun getSearchGameResult(name: String): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: List<GameEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: GameEntity)

    @Update
    suspend fun updateGame(game: GameEntity)
}