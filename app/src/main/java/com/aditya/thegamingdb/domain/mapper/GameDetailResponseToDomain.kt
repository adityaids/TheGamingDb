package com.aditya.thegamingdb.domain.mapper

import com.aditya.thegamingdb.data.source.remote.dto.GameDetailResponseDTO
import com.aditya.thegamingdb.domain.dto.GameResponse

class GameDetailResponseToDomain {
    fun map(data: GameDetailResponseDTO) =
        GameResponse(
            id = data.id,
            name = data.name,
            gameImage = data.image,
            description = data.description,
            released = data.released,
            rating = data.rating,
            isFavorite = data.isFavorited,
            isLatest = data.isLatest
        )
}