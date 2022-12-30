package com.aditya.thegamingdb.util

sealed class Result<out T: Any?> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val errorMessage: String) : Result<Nothing>()

}