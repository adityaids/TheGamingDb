package com.aditya.thegamingdb.data.source.db

import com.aditya.thegamingdb.data.repository.source.db.GameDbData
import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import com.aditya.thegamingdb.data.source.db.room.GameDao

class GameDbDataImpl(
    private val gameDao: GameDao
) : GameDbData {
    override fun getPopularGame() = gameDao.getPopularGame()
    override fun getLatestGame() = gameDao.getLatestGame()
    override fun getAllFavorit() = gameDao.getAllFavorite()
    override suspend fun updateFavorit(game: GameEntity) = gameDao.updateGame(game)
    override fun getSearchGameResult(name: String) = gameDao.getSearchGameResult(name)
    override suspend fun insertGame(gameList: List<GameEntity>) = gameDao.insertGame(gameList)
    override suspend fun addGame(game: GameEntity) = gameDao.insertGame(game)
}