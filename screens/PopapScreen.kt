package org.wikipedia.espresso_test.mobile.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R


class PopapScreen {

    private val settingsButton = withId(R.id.main_drawer_settings_container)
    private val loginButton = withId(R.id.main_drawer_login_button)

    fun clickSettingsButton() {
        onView(settingsButton)
            .perform(click())
    }

    fun clickLoginButton() {
        onView(loginButton)
            .perform(click())
    }

    companion object {
        inline operator fun invoke(crossinline block: PopapScreen.() -> Unit) =
            PopapScreen().block()
    }
}