package org.wikipedia.espresso_test.mobile.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.espresso_test.mobile.screens.LoginScreen
import org.wikipedia.espresso_test.mobile.screens.MainScreen
import org.wikipedia.espresso_test.mobile.screens.PopapScreen
import org.wikipedia.espresso_test.mobile.screens.StartingOnBoardingScreen

@RunWith(AndroidJUnit4::class)
class ClosingPasswordTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun closingPassword() {
        val passwordValue = "password"

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
            clickPasswordField()
            typeTextToPasswordFiled(passwordValue)
            clickSeePassword()
            checkTextOnPasswordFiled(passwordValue)
            clickSeePassword()
            checkPasswordHidden(passwordValue)
        }
    }
}