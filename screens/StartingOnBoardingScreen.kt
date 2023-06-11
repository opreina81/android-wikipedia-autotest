package org.wikipedia.espresso_test.mobile.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class StartingOnBoardingScreen {

    private val skipButton = withId(R.id.fragment_onboarding_skip_button)

    fun clickSkipButton() {
        onView(skipButton)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: StartingOnBoardingScreen.() -> Unit) =
            StartingOnBoardingScreen().block()
    }

}