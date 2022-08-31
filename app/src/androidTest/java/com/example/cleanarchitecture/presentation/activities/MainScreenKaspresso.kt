package com.example.cleanarchitecture.presentation.activities

import com.example.cleanarchitecture.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText

//Screen for Kaspresso
object MainScreenKaspresso: KScreen<MainScreenKaspresso>(){
    override val layoutId: Int = R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val dataEditText = KEditText {withId(R.id.data_edit_text)}
}