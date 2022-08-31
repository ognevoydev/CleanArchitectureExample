package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.data.mappers.mapToDomain
import com.example.cleanarchitecture.data.mappers.mapToStorage
import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.repositories.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.saveToPrefs(saveParam.mapToStorage())
    }

    override fun getName(): GetUserNameParam {

        val user = userStorage.getFromPrefs()
        return user.mapToDomain()
    }
}