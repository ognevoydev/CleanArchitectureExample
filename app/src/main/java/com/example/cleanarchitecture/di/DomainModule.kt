package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.repositories.UserRepository
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

//    @Provides
//    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
//        return GetUserNameUseCase(userRepository = userRepository)
//    }
//
//    @Provides
//    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
//        return SaveUserNameUseCase(userRepository = userRepository)
//    }
}