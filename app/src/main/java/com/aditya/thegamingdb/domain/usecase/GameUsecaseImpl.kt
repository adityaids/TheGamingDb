package com.aditya.thegamingdb.domain.usecase

import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.domain.usecase.entity.GameUsecase
import com.aditya.thegamingdb.domain.usecase.repository.GameRepository
import com.aditya.thegamingdb.util.Result
import kotlinx.coroutines.flow.Flow

class GameUsecaseImpl(
    private val repository: GameRepository
): GameUsecase {
    override fun getPopularGame(): Flow<Result<List<GameResponse>>> =
        repository.getPopularGame()

    override fun getLatestGame(): Flow<Result<List<GameResponse>>> =
        repository.getLatestGame()

    override fun getDetail(id: Int): Flow<Result<GameResponse>> =
        repository.getDetail(id)

    override suspend fun setFavorit(game: GameResponse) =
        repository.setFavorit(game)

    override suspend fun updateFavorit(game: GameResponse) =
        repository.updateFavorit(game)

    override fun getFavoritList(): Flow<Result<List<GameResponse>>> =
        repository.getFavoritList()

    override fun getSearchGameResult(title: String): Flow<Result<List<GameResponse>>> =
        repository.getSearchGameResult(title)
}