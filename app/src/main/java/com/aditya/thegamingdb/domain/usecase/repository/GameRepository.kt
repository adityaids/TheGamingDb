package com.aditya.thegamingdb.domain.usecase.repository

import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.util.Result
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getPopularGame(): Flow<Result<List<GameResponse>>>
    fun getLatestGame(): Flow<Result<List<GameResponse>>>
    fun getDetail(id: Int): Flow<Result<GameResponse>>
    suspend fun setFavorit(game: GameResponse)
    suspend fun updateFavorit(game: GameResponse)
    fun getFavoritList(): Flow<Result<List<GameResponse>>>
    fun getSearchGameResult(title: String): Flow<Result<List<GameResponse>>>
}