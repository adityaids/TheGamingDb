package com.aditya.thegamingdb.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class GamesListResponseDTO(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("results")
    val gameList: List<GameResponseApiDTO>
)