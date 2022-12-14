package com.aditya.thegamingdb.di

import com.aditya.thegamingdb.domain.mapper.GameDetailResponseToDomain
import com.aditya.thegamingdb.domain.mapper.GameReqToEntity
import com.aditya.thegamingdb.domain.mapper.GameResponseDbToDomainMapper
import com.aditya.thegamingdb.domain.mapper.GameResponseToEntityMapper
import org.koin.dsl.module

val MapperModule = module {
    single { GameResponseDbToDomainMapper() }
    single { GameResponseToEntityMapper() }
    single { GameDetailResponseToDomain() }
    single { GameReqToEntity() }
}