package org.wikipedia.espresso_test.mobile.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.espresso_test.mobile.screens.LoginScreen
import org.wikipedia.espresso_test.mobile.screens.MainScreen
import org.wikipedia.espresso_test.mobile.screens.PopapScreen
import org.wikipedia.espresso_test.mobile.screens.StartingOnBoardingScreen
import org.wikipedia.main.MainActivity


@RunWith(AndroidJUnit4::class)
class ErrorMessageTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun validPassword() {
        val loginValue = "qamobile"
        val passwordValue = "pass"

        StartingOnBoardingScreen {
            clickSkipButton()
        }
        MainScreen {
            clickMoreButton()
        }
        PopapScreen {
            clickLoginButton()
        }
        LoginScreen {
            typeTextToLoginFiled(loginValue)
            clickPasswordField()
            typeTextToPasswordFiled(passwordValue)
            clickButtonSubmitMatcher()
            redErrorMessageAppeared()
        }
    }
}