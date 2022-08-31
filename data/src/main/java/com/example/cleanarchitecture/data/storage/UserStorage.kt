package com.example.cleanarchitecture.data.storage

import com.example.cleanarchitecture.data.storage.models.User

interface UserStorage {

    fun saveToPrefs(user: User): Boolean

    fun getFromPrefs(): User
}