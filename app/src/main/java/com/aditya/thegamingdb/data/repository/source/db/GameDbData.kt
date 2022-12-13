package com.aditya.thegamingdb.data.repository.source.db

import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface GameDbData {
    fun getPopularGame(): Flow<List<GameEntity>>
    fun getLatestGame(): Flow<List<GameEntity>>
    fun getAllFavorit(): Flow<List<GameEntity>>
    suspend fun updateFavorit(game: GameEntity)
    fun getSearchGameResult(name: String): Flow<List<GameEntity>>
    suspend fun insertGame(gameList: List<GameEntity>)
}