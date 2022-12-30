package com.aditya.thegamingdb.data.repository

import com.aditya.thegamingdb.data.repository.source.db.GameDbData
import com.aditya.thegamingdb.data.repository.source.remote.GameRemoteData
import com.aditya.thegamingdb.data.source.remote.dto.GameResponseApiDTO
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.domain.mapper.GameDetailResponseToDomain
import com.aditya.thegamingdb.domain.mapper.GameReqToEntity
import com.aditya.thegamingdb.domain.mapper.GameResponseToEntityMapper
import com.aditya.thegamingdb.domain.mapper.GameResponseDbToDomainMapper
import com.aditya.thegamingdb.domain.usecase.repository.GameRepository
import com.aditya.thegamingdb.util.ApiResponse
import com.aditya.thegamingdb.util.NetworkBoundSource
import com.aditya.thegamingdb.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GameRepositoryImpl(
    private val gameLocalData: GameDbData,
    private val gameRemoteData: GameRemoteData,
    private val responseToEntityMapper: GameResponseToEntityMapper,
    private val entityToDomainMapper: GameResponseDbToDomainMapper,
    private val detailResponseToDomain: GameDetailResponseToDomain,
    private val gameReqToEntity: GameReqToEntity
): GameRepository {

    override fun getPopularGame(): Flow<Result<List<GameResponse>>> =
        object : NetworkBoundSource<List<GameResponse>, List<GameResponseApiDTO>>(){
            override suspend fun loadFromDB(): Flow<List<GameResponse>> {
                return gameLocalData.getPopularGame().map { entityToDomainMapper.map(it) }
            }

            override suspend fun shouldFetch(data: List<GameResponse>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponseApiDTO>>> =
                gameRemoteData.getPopular()

            override suspend fun saveCallResult(data: List<GameResponseApiDTO>) {
                val gameList = responseToEntityMapper.map(data)
                gameLocalData.insertGame(gameList)
            }

        }.asFlow()

    override fun getLatestGame(): Flow<Result<List<GameResponse>>> =
        object : NetworkBoundSource<List<GameResponse>, List<GameResponseApiDTO>>(){
            override suspend fun loadFromDB(): Flow<List<GameResponse>> {
                return gameLocalData.getLatestGame().map { entityToDomainMapper.map(it) }
            }

            override suspend fun shouldFetch(data: List<GameResponse>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponseApiDTO>>> =
                gameRemoteData.getLatest()

            override suspend fun saveCallResult(data: List<GameResponseApiDTO>) {
                val gameList = responseToEntityMapper.map(data)
                gameLocalData.insertGame(gameList)
            }

        }.asFlow()

    override fun getDetail(id: Int): Flow<Result<GameResponse>> =
        flow {
            when (val apiResponse = gameRemoteData.getGameDetail(id).first()) {
                is ApiResponse.Success -> {
                    val data = detailResponseToDomain.map(apiResponse.data)
                    emit(Result.Success(data))
                }
                is ApiResponse.Empty -> emit(Result.Success(GameResponse()))
                is ApiResponse.Error -> emit(Result.Error(apiResponse.errorMessage))
            }
        } as Flow<Result<GameResponse>>

    override suspend fun setFavorit(game: GameResponse) {
        val gameEntity = gameReqToEntity.map(game)
        withContext(Dispatchers.IO){
            gameLocalData.updateFavorit(gameEntity)
        }
    }

    override suspend fun updateFavorit(game: GameResponse) {
        val gameEntity = gameReqToEntity.map(game)
        withContext(Dispatchers.IO){
            gameLocalData.updateFavorit(gameEntity)
        }
    }

    override fun getFavoritList(): Flow<List<GameResponse>> {
        return gameLocalData.getAllFavorit().map { entityToDomainMapper.map(it) }
    }

    override fun getSearchGameResult(title: String): Flow<Result<List<GameResponse>>> =
        object : NetworkBoundSource<List<GameResponse>, List<GameResponseApiDTO>>(){
            override suspend fun loadFromDB(): Flow<List<GameResponse>> {
                return gameLocalData.getSearchGameResult(title).map { entityToDomainMapper.map(it) }
            }

            override suspend fun shouldFetch(data: List<GameResponse>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponseApiDTO>>> =
                gameRemoteData.getSearchGameResult(title)


            override suspend fun saveCallResult(data: List<GameResponseApiDTO>) {
                val game = responseToEntityMapper.map(data)
                gameLocalData.insertGame(game)
            }

        }.asFlow()

}