package com.aditya.thegamingdb.data.source.remote.api

import com.aditya.thegamingdb.data.source.remote.dto.GameDetailResponseDTO
import com.aditya.thegamingdb.data.source.remote.dto.GamesListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameRemoteService {
    @GET("games?key=&search=")
    suspend fun searchGame(
        @Query("key") key: String,
        @Query("search") search: String
    ): GamesListResponseDTO

    @GET("games?key=&ordering=updated")
    suspend fun latestGame(
        @Query("key") key: String
    ): GamesListResponseDTO

    @GET("games?key=&metacritics=75")
    suspend fun popularGames(
        @Query("key") key: String
    ): GamesListResponseDTO

    @GET("games/{id}")
    suspend fun getGameDetail(
        @Path("id") gamesId: Int,
        @Query("key") key: String
    ): GameDetailResponseDTO
}