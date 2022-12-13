package com.aditya.thegamingdb.domain.mapper

import com.aditya.thegamingdb.data.source.remote.dto.GameDetailResponseDTO
import com.aditya.thegamingdb.domain.dto.GameDetailResponse
import com.aditya.thegamingdb.domain.dto.GameResponse

class GameDetailResponseToDomain {
    fun map(data: GameDetailResponseDTO) =
        GameDetailResponse(
            id = data.id,
            name = data.name,
            image = data.image,
            description = data.description,
            released = data.released,
            rating = data.rating,
            isFavorited = false,
            isLatest = false
        )
}