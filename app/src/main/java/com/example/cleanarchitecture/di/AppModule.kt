package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import com.example.cleanarchitecture.presentation.activities.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

//    @Provides
//    fun provideMainViewModelFactory(getUserNameUseCase: GetUserNameUseCase,
//                                    saveUserNameUseCase: SaveUserNameUseCase
//    ): MainViewModelFactory {
//        return MainViewModelFactory(getUserNameUseCase = getUserNameUseCase,
//            saveUserNameUseCase = saveUserNameUseCase)
//    }
}