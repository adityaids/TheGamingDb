package com.aditya.thegamingdb.domain.dto

data class GameResponse(
    var id: Int = 0,
    var name: String? = "",
    var gameImage: String? = "",
    var description: String? = "",
    var released: String? = "",
    var rating: Float = 0.0f,
    var isFavorite: Boolean = false,
    var isLatest: Boolean = false
)