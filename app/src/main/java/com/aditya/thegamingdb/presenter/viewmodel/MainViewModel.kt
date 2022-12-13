package com.aditya.thegamingdb.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.domain.usecase.entity.GameUsecase
import kotlinx.coroutines.launch

class MainViewModel(
    private val gameUsecase: GameUsecase
): ViewModel() {

    val popularGameList= gameUsecase.getPopularGame().asLiveData()
    val latestGameList = gameUsecase.getLatestGame().asLiveData()
    fun getDetailGame(id: Int) = gameUsecase.getDetail(id).asLiveData()
    fun setFavorit(gameModel: GameResponse) {
        viewModelScope.launch {
            gameUsecase.setFavorit(gameModel)
        }
    }
    fun updateFavorit(gameModel: GameResponse) {
        viewModelScope.launch {
            gameUsecase.setFavorit(gameModel)
        }
    }
    fun getSearchGameResult(title: String) = gameUsecase.getSearchGameResult(title).asLiveData()
}