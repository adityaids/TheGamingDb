package com.aditya.thegamingdb.data.source.remote

import com.aditya.thegamingdb.data.repository.source.remote.GameRemoteData
import com.aditya.thegamingdb.data.source.remote.api.GameRemoteService
import com.aditya.thegamingdb.data.source.remote.dto.GameDetailResponseDTO
import com.aditya.thegamingdb.data.source.remote.dto.GameResponseApiDTO
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.util.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameRemoteDataImpl(
    private val gameRemoteService: GameRemoteService
): GameRemoteData {
    companion object{
        const val API_KEY: String = "4fa30b393b76408194e80b0dde0e3860"
    }

    override suspend fun getPopular(): Flow<ApiResponse<List<GameResponseApiDTO>>> {
        return flow {
            try {
                val response = gameRemoteService.popularGames(API_KEY)
                val dataArray = response.gameList
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.gameList))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getLatest(): Flow<ApiResponse<List<GameResponseApiDTO>>> {
        return flow {
            try {
                val response = gameRemoteService.latestGame(API_KEY)
                val dataArray = response.gameList
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.gameList))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSearchGameResult(title: String): Flow<ApiResponse<List<GameResponseApiDTO>>> {
        return flow {
            try {
                val response = gameRemoteService.searchGame(API_KEY, title)
                val dataArray = response.gameList
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.gameList))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getGameDetail(id: Int): Flow<ApiResponse<GameDetailResponseDTO>> {
        return flow {
            try {
                val response = gameRemoteService.getGameDetail(id, API_KEY)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}