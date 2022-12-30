package com.aditya.thegamingdb.di

import com.aditya.thegamingdb.data.repository.GameRepositoryImpl
import com.aditya.thegamingdb.data.repository.source.db.GameDbData
import com.aditya.thegamingdb.data.repository.source.remote.GameRemoteData
import com.aditya.thegamingdb.data.source.db.GameDbDataImpl
import com.aditya.thegamingdb.data.source.remote.GameRemoteDataImpl
import com.aditya.thegamingdb.domain.mapper.GameDetailResponseToDomain
import com.aditya.thegamingdb.domain.mapper.GameReqToEntity
import com.aditya.thegamingdb.domain.mapper.GameResponseDbToDomainMapper
import com.aditya.thegamingdb.domain.mapper.GameResponseToEntityMapper
import com.aditya.thegamingdb.domain.usecase.GameUsecaseImpl
import com.aditya.thegamingdb.domain.usecase.entity.GameUsecase
import com.aditya.thegamingdb.domain.usecase.repository.GameRepository
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory<GameDbData> {
        GameDbDataImpl(get())
    }
    factory<GameRemoteData> {
        GameRemoteDataImpl(get())
    }
}

val repositoryModule = module {
    factory<GameRepository> {
        GameRepositoryImpl(
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
}

val usecaseModule = module {
    factory<GameUsecase> {
        GameUsecaseImpl(
            get()
        )
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val mapperModule = module {
    factory { GameResponseToEntityMapper() }
    factory { GameResponseDbToDomainMapper() }
    factory { GameDetailResponseToDomain() }
    factory { GameReqToEntity() }
}