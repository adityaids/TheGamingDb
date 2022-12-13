package com.aditya.thegamingdb.data.repository.source.db

import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import kotlinx.coroutines.flow.Flow

interface GameDbData {
    suspend fun getPopularGame(): Flow<List<GameEntity>>
    suspend fun getLatestGame(): Flow<List<GameEntity>>
    suspend fun getAllFavorit(): Flow<List<GameEntity>>
    suspend fun updateFavorit(game: GameEntity)
    suspend fun getSearchGameResult(name: String): Flow<List<GameEntity>>
    suspend fun insertGame(gameList: List<GameEntity>)
}