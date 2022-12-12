package com.aditya.thegamingdb.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class GameResponseApiDTO (
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("background_image")
    val image: String?,
    @field:SerializedName("released")
    val released: String?,
    @field:SerializedName("rating")
    val rating: Float
)