package com.aditya.thegamingdb.domain.mapper

import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import com.aditya.thegamingdb.domain.dto.GameResponse

class GameResponseDbToDomainMapper {
    fun map(data: List<GameEntity>): List<GameResponse> =
        data.map {
            GameResponse(
                id = it.id,
                name = it.name,
                gameImage = it.gameImage,
                description = it.description,
                released = it.released,
                rating = it.rating,
                isFavorite = it.isFavorite,
                isLatest = it.isLatest
            )
        }
}