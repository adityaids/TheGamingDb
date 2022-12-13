package com.aditya.thegamingdb.domain.mapper

import com.aditya.thegamingdb.data.source.db.entity.GameEntity
import com.aditya.thegamingdb.domain.dto.GameResponse

class GameReqToEntity {
    fun map(input: GameResponse) = GameEntity(
        id = input.id,
        name = input.name?:"empty",
        gameImage = input.gameImage?:"",
        description = input.description?:"empty",
        released = input.released?:"unknown",
        rating = input.rating,
        isFavorite = input.isFavorite,
        isLatest = input.isLatest
    )
}