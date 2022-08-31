package com.example.cleanarchitecture.data.mappers

import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam

fun SaveUserNameParam.mapToStorage() = User(
    firstName = name,
    lastName = ""
)

fun User.mapToDomain() = GetUserNameParam(
    firstName = firstName,
    lastName = lastName
)