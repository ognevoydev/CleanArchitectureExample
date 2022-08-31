package com.example.cleanarchitecture.domain.repositories

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.GetUserNameParam

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): GetUserNameParam
}