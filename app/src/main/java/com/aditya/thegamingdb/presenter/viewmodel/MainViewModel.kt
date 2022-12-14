package com.aditya.thegamingdb.presenter.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.domain.usecase.entity.GameUsecase
import com.aditya.thegamingdb.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainViewModel(
    private val gameUsecase: GameUsecase
): ViewModel() {

    private val _popularGameList= MutableStateFlow(
        gameUsecase.getPopularGame()
    )
    //val popularGameList: StateFlow<Map<Char, List<GameResponse>>> get() = _popularGameList

    fun getPopularGame() {
        viewModelScope.launch {
            val data = gameUsecase.getPopularGame().collect()
            when (data) {

            }
        }
    }
    private val _latestGameList = MutableStateFlow(
        gameUsecase.getLatestGame()
    )
    fun getDetailGame(id: Int) = MutableStateFlow(
        gameUsecase.getDetail(id)
    )
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
    fun search(title: String) = MutableStateFlow(
        gameUsecase.getSearchGameResult(title)
    )
}