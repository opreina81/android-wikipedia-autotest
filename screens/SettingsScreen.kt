package org.wikipedia.espresso_test.mobile.screens

import android.app.Instrumentation
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R


class SettingsScreen {

    private val exploreFeed = withText(R.string.preference_title_customize_explore_feed)
    private val aboutApp = withText(R.string.about_description)
    private val privacyPolicy = withText(R.string.privacy_policy_description)
    private val viewRecycler = withId(R.id.recycler_view)

    fun clickExploreFeed() {
        onView(exploreFeed)
            .perform(click())
    }

    fun clickAboutApp() {
        onView(aboutApp)
            .perform(click())
    }

    fun clickPrivacyPolicy() {
        Intents.init()
        val expectedIntent = allOf(
            IntentMatchers.hasAction(Intent.ACTION_VIEW),
        )
        Intents.intending(expectedIntent).respondWith(Instrumentation.ActivityResult(0, null))
        onView(privacyPolicy)
            .perform(click())
        Intents.intended(expectedIntent)
        Intents.release()
    }

    fun swipeScreen() {
        onView(viewRecycler)
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())

    }

    companion object {
        inline operator fun invoke(crossinline block: SettingsScreen.() -> Unit) =
            SettingsScreen().block()
    }
}
