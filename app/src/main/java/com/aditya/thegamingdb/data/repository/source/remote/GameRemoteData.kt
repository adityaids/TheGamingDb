package com.aditya.thegamingdb.data.repository.source.remote

import com.aditya.thegamingdb.data.source.remote.dto.GameDetailResponseDTO
import com.aditya.thegamingdb.data.source.remote.dto.GameResponseApiDTO
import com.aditya.thegamingdb.util.ApiResponse
import kotlinx.coroutines.flow.Flow

interface GameRemoteData {
    suspend fun getPopular(): Flow<ApiResponse<List<GameResponseApiDTO>>>
    suspend fun getLatest(): Flow<ApiResponse<List<GameResponseApiDTO>>>
    suspend fun getSearchGameResult(title: String): Flow<ApiResponse<List<GameResponseApiDTO>>>
    suspend fun getGameDetail(id: Int): Flow<ApiResponse<GameDetailResponseDTO>>
}