package com.example.cleanarchitecture.domain.usecases

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repositories.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown(){
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name was already saved`(){

        val testGetUserNameParam = GetUserNameParam(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testGetUserNameParam)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val testParams = SaveUserNameParam(name = "test first name")

        val actual = useCase.execute(testParams)
        val expected = true

        assertThat(actual).isEqualTo(expected)
        Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())
    }

    @Test
    fun `should return true if save was successful`(){
        val testGetUserNameParam = GetUserNameParam(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testGetUserNameParam)

        val testParams = SaveUserNameParam(name = "new first name")
        val expected = true
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val actual = useCase.execute(testParams)
        assertThat(actual).isEqualTo(expected)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

    @Test
    fun `should return false if save was successful`(){
        val testGetUserNameParam = GetUserNameParam(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testGetUserNameParam)

        val testParams = SaveUserNameParam(name = "new first name")
        val expected = false
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val actual = useCase.execute(testParams)
        assertThat(actual).isEqualTo(expected)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }
}