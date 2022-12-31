package com.aditya.thegamingdb.presenter.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.domain.usecase.entity.GameUsecase
import com.aditya.thegamingdb.util.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val gameUsecase: GameUsecase
): ViewModel() {

    private val _popularGameList: MutableStateFlow<Result<List<GameResponse>>> = MutableStateFlow(Result.Loading)
    val popularGameList: StateFlow<Result<List<GameResponse>>>
        get() = _popularGameList

    fun getPopularGame() {
        viewModelScope.launch {
            gameUsecase.getPopularGame()
                .catch {
                    _popularGameList.value = Result.Error(it.message.toString())
                }
                .collect { gameList ->
                    _popularGameList.value = gameList
                }
        }
    }

    private val _favoriteGameList: MutableStateFlow<Result<List<GameResponse>>> = MutableStateFlow(Result.Loading)
    val favoriteGameList: StateFlow<Result<List<GameResponse>>>
        get() = _favoriteGameList

    fun getFavoriteGameList() {
        viewModelScope.launch {
            gameUsecase.getFavoritList()
                .catch {
                    _favoriteGameList.value = Result.Error(it.message.toString())
                }
                .collect { gameList ->
                    _favoriteGameList.value = gameList
                }
        }
    }

    private val _detailGame: MutableStateFlow<Result<GameResponse>> = MutableStateFlow(Result.Loading)
    val detailGame: StateFlow<Result<GameResponse>>
        get() = _detailGame

    fun getDetailGame(id: Int) {
        viewModelScope.launch {
            gameUsecase.getDetail(id)
                .catch {
                    _detailGame.value = Result.Error(it.message.toString())
                }
                .collect { game ->
                    _detailGame.value = game
                }
        }
    }
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

    private val _searchGameList: MutableStateFlow<Result<List<GameResponse>>> = MutableStateFlow(Result.Loading)
    val searchGameList: StateFlow<Result<List<GameResponse>>>
        get() = _searchGameList

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(title: String) {
        _query.value = title
        viewModelScope.launch {
            gameUsecase.getSearchGameResult(_query.value)
                .catch {
                    _searchGameList.value = Result.Error(it.message.toString())
                }
                .collect { gameList ->
                    _searchGameList.value = gameList
                }
        }
    }
}