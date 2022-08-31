package com.example.cleanarchitecture.data.storage

import android.content.Context
import com.example.cleanarchitecture.data.DEFAULT_NAME
import com.example.cleanarchitecture.data.KEY_FIRST_NAME
import com.example.cleanarchitecture.data.KEY_LAST_NAME
import com.example.cleanarchitecture.data.SHARED_PREFS_NAME
import com.example.cleanarchitecture.data.storage.models.User

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveToPrefs(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        return true
    }

    override fun getFromPrefs(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}