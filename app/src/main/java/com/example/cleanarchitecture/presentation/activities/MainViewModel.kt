package com.example.cleanarchitecture.presentation.activities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase

private const val TAG = "ViewModel"

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase,
                    private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {

    private val resultLiveDataMutable = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultLiveDataMutable

    fun saveData(text: String){
        val params = SaveUserNameParam(name = text)
        val resultBool: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveDataMutable.value = "Save result = $resultBool"
    }

    fun getData(){
        val userName: GetUserNameParam = getUserNameUseCase.execute()
        resultLiveDataMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}