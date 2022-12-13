package com.aditya.thegamingdb.domain.mapper

import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import com.aditya.thegamingdb.data.source.remote.dto.GameResponseApiDTO

class GameResponseToEntityMapper {

    fun map(data: List<GameResponseApiDTO>): List<GameEntity> {
        val listGame = ArrayList<GameEntity>()
        data.forEach {
            val game = GameEntity(
                id = it.id,
                name = it.name,
                gameImage = it.image ?: "",
                description = "empty",
                released = it.released ?: "",
                rating = it.rating,
                isFavorite = false,
                isLatest = false
            )
            listGame.add(game)
        }
        return listGame
    }
}