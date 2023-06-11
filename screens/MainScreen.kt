package org.wikipedia.espresso_test.mobile.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class MainScreen {

    private val moreButton = withId(R.id.menu_icon)

    fun clickMoreButton() {
        onView(moreButton)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: MainScreen.() -> Unit) = MainScreen().block()
    }
}