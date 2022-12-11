package com.aditya.thegamingdb.data.repository

import com.aditya.thegamingdb.data.repository.source.db.GameDbData
import com.aditya.thegamingdb.data.repository.source.remote.GameRemoteData
import com.aditya.thegamingdb.domain.usecase.repository.GameRepository

class GameRepositoryImpl(
    gameDatabase: GameDbData,
    gameRemoteData: GameRemoteData
): GameRepository {

}