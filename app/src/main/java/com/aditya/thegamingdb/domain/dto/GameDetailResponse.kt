package com.aditya.thegamingdb.domain.dto

data class GameDetailResponse(
    val id: Int,
    val name: String,
    val image: String,
    val released: String,
    val description: String,
    val rating: Float,
    var isFavorited: Boolean,
    var isLatest: Boolean
)