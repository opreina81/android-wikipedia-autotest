package org.wikipedia.espresso_test.mobile.test

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.espresso_test.mobile.screens.ExploreFeed

import org.wikipedia.espresso_test.mobile.screens.MainScreen
import org.wikipedia.espresso_test.mobile.screens.PopapScreen
import org.wikipedia.espresso_test.mobile.screens.SettingsScreen
import org.wikipedia.espresso_test.mobile.screens.StartingOnBoardingScreen

@RunWith(AndroidJUnit4::class)
class SettingsFeedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun settingsFeed() {
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
            clickExploreFeed()
        }
        ExploreFeed {
            checkCheckboxFeaturedArticleTrue()
            checkCheckboxTopReadTrue()
            checkCheckboxPictureDayTrue()
            checkCheckboxBecauseYouReadTrue()
            checkCheckboxInNewsTrue()
            checkCheckboxOnThisDayTrue()
            scrollTo()
            checkCheckboxRandomizerTrue()
            checkCheckboxTodayOnWikipediaTrue()
        }
    }
}