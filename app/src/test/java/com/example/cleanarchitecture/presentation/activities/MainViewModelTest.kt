package com.example.cleanarchitecture.presentation.activities

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.jupiter.api.*

class MainViewModelTest {

    private val getUserNameUseCase = mockk<GetUserNameUseCase>()
    private val saveUserNameUseCase = mockk<SaveUserNameUseCase>()

    @BeforeEach
    fun beforeEach(){
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor(){
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }
        })
    }

    @AfterEach
    fun afterEach(){
        unmockkAll()
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @Test
    fun `should save username and return true`(){

        val testSaveText = "test user name"
        val testParams = SaveUserNameParam(name = testSaveText)

        every { saveUserNameUseCase.execute(param = any()) } returns true

        val viewModel = MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase, getUserNameUseCase = getUserNameUseCase
        )

        viewModel.saveData(testSaveText)

        val expected = "Save result = true"
        val actual = viewModel.resultLiveData.value
        verify {saveUserNameUseCase.execute(param = testParams)}
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should save username and return false`(){
        val testSaveText = "test user name"
        val testParams = SaveUserNameParam(name = testSaveText)

        every { saveUserNameUseCase.execute(param = any()) } returns false

        val viewModel = MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase, getUserNameUseCase = getUserNameUseCase
        )

        viewModel.saveData(testSaveText)

        val expected = "Save result = false"
        val actual = viewModel.resultLiveData.value
        verify {saveUserNameUseCase.execute(param = testParams)}
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should load username`(){
        val testGetUserNameParam = GetUserNameParam(
            firstName = "test first name", lastName = "test last name")

        every { getUserNameUseCase.execute() } returns testGetUserNameParam

        val viewModel = MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase, getUserNameUseCase = getUserNameUseCase
        )
        viewModel.getData()
        val expected = "${testGetUserNameParam.firstName} ${testGetUserNameParam.lastName}"
        val actual = viewModel.resultLiveData.value
        assertThat(actual).isEqualTo(expected)
    }
}