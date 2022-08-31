package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.repositories.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor( val userRepository: UserRepository) {

    fun execute(): GetUserNameParam {
        return userRepository.getName()
    }

    //Для вызова юскейса как функции
//    operator fun invoke(): GetUserNameParam {
//        return userRepository.getName()
//    }
}