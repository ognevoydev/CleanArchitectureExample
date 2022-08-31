package com.example.cleanarchitecture.presentation.activities

import android.text.InputType
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cleanarchitecture.R
import io.github.kakaocup.kakao.screen.Screen.Companion.onScreen
import org.hamcrest.Matchers.allOf
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest: TestCase() {

    //espresso

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun editableCheck() {
        onView(withId(R.id.data_edit_text)).check(matches(allOf(
            withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
            isFocusable(),
            isClickable(),
            withInputType(InputType.TYPE_CLASS_TEXT),
            withText("")
        )))
    }

    @Test
    fun editableInput() {
        val testData = "test data"
        onView(withId(R.id.data_edit_text)).perform(typeText(testData))
        closeSoftKeyboard()
        onView(withId(R.id.data_edit_text)).check(matches(withText(testData)))
    }

    //kakao

    @Test
    fun editableCheckKakao() {
        onScreen<MainScreenKakao> {
            dataEditText {
                isVisible()
                isFocusable()
                isClickable()
                withInputType(InputType.TYPE_CLASS_TEXT)
                hasText("")
            }
        }
    }

    @Test
    fun editableInputKakao() {
        val testData = "test data"
        onScreen<MainScreenKakao> {
            dataEditText {
                typeText(testData)
            }
            closeSoftKeyboard()
            dataEditText {
                hasText(testData)
            }
        }
    }

    //kaspresso

    @Test
    fun editableCheckKaspresso() = run {
        step("Check dataEditText"){
            MainScreenKaspresso {
                dataEditText {
                    isVisible()
                    isFocusable()
                    isClickable()
                    withInputType(InputType.TYPE_CLASS_TEXT)
                    hasText("")
                }
            }
        }
    }

    @Test
    fun editableInputKaspresso() = run {
        val testData = "test data"
        step("Check dataEditText") {
            MainScreenKaspresso {
                dataEditText {
                    typeText(testData)
                }
                closeSoftKeyboard()
                dataEditText {
                    hasText(testData)
                }
            }
        }
    }
}