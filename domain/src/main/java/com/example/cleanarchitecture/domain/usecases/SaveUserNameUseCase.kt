package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repositories.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor( val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()
        return if(oldUserName.firstName == param.name) true
        else userRepository.saveName(saveParam = param)
    }
}