package com.example.cleanarchitecture.presentation.activities

import com.example.cleanarchitecture.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen

//Screen for Kakao
class MainScreenKakao: Screen<MainScreenKakao>(){
    val dataEditText = KEditText {withId(R.id.data_edit_text)}
}