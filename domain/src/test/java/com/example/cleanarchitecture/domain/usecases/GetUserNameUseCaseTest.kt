package com.example.cleanarchitecture.domain.usecases

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.repositories.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return correct data`(){

        val testGetUserNameParam = GetUserNameParam(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testGetUserNameParam)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = GetUserNameParam(firstName = "test first name", lastName = "test last name")

        assertThat(actual).isEqualTo(expected)
    }
}