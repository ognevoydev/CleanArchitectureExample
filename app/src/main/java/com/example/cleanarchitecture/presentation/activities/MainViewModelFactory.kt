package com.example.cleanarchitecture.presentation.activities

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repositories.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val getUserNameUseCase: GetUserNameUseCase,
                           val saveUserNameUseCase: SaveUserNameUseCase): ViewModelProvider.Factory {

    //private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
    //private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    //private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase
            , saveUserNameUseCase = saveUserNameUseCase) as T
    }
}