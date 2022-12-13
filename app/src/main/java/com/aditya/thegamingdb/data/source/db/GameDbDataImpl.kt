package com.aditya.thegamingdb.data.source.db

import com.aditya.thegamingdb.data.repository.source.db.GameDbData
import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import com.aditya.thegamingdb.data.source.db.room.GameDao

class GameDbDataImpl(
    private val gameDao: GameDao
) : GameDbData {
    override suspend fun getPopularGame() = gameDao.getPopularGame()
    override suspend fun getLatestGame() = gameDao.getLatestGame()
    override suspend fun getAllFavorit() = gameDao.getAllFavorite()
    override suspend fun updateFavorit(game: GameEntity) = gameDao.updateGame(game)
    override suspend fun getSearchGameResult(name: String) = gameDao.getSearchGameResult(name)
    override suspend fun insertGame(gameList: List<GameEntity>) = gameDao.insertGame(gameList)
}