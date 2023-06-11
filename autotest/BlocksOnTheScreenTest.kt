package org.wikipedia.espresso_test.mobile.test

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.espresso_test.mobile.screens.AboutAppScreen
import org.wikipedia.espresso_test.mobile.screens.MainScreen
import org.wikipedia.espresso_test.mobile.screens.PopapScreen
import org.wikipedia.espresso_test.mobile.screens.SettingsScreen
import org.wikipedia.espresso_test.mobile.screens.StartingOnBoardingScreen

@RunWith(AndroidJUnit4::class)
class BlocksOnTheScreenTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun blocksOnTheScreen() {

        StartingOnBoardingScreen {
            clickSkipButton()
        }
        MainScreen {
            clickMoreButton()
        }
        PopapScreen {
            clickSettingsButton()
        }
        SettingsScreen {
            swipeScreen()
            clickAboutApp()
        }
        AboutAppScreen {
            checkBlockAuthors()
            checkBlockTranslators()
            checkBlockLicense()
        }
    }
}



