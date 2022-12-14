package com.aditya.thegamingdb.di

import com.aditya.thegamingdb.data.repository.GameRepositoryImpl
import com.aditya.thegamingdb.domain.usecase.GameUsecaseImpl
import com.aditya.thegamingdb.domain.usecase.entity.GameUsecase
import com.aditya.thegamingdb.domain.usecase.repository.GameRepository
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

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