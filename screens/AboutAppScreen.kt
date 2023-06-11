package org.wikipedia.espresso_test.mobile.screens


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.wikipedia.R
import org.wikipedia.views.AppTextView

class AboutAppScreen {
    private val blockAuthors =
        allOf(instanceOf(AppTextView::class.java), withId(R.id.about_contributors))
    private val blockTranslators =
        allOf(instanceOf(AppTextView::class.java), withId(R.id.about_translators))
    private val blockLicense =
        allOf(instanceOf(AppTextView::class.java), withId(R.id.about_app_license))

    fun checkBlockAuthors() {
        onView(blockAuthors)
            .check(matches(isDisplayed()))
    }

    fun checkBlockTranslators() {
        onView(blockTranslators)
            .check(matches(isDisplayed()))
    }

    fun checkBlockLicense() {
        onView(blockLicense)
           .check(matches(isDisplayed()))
    }
    companion object {
        inline operator fun invoke(crossinline block: AboutAppScreen.() -> Unit) = AboutAppScreen().block()
    }
}