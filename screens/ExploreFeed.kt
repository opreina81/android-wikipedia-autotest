package org.wikipedia.espresso_test.mobile.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class ExploreFeed {

    private val checkboxFeaturedArticle = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_featured_article_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxTopRead = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_top_read_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxPictureDay = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_featured_image_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxBecauseYouRead = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_because_you_read_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxInNews = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_card_news_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxOnThisDay = allOf(
        hasSibling(
            withChild(
                withText(R.string.on_this_day_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxRandomizer = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_random_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val checkboxTodayOnWikipedia = allOf(
        hasSibling(
            withChild(
                withText(R.string.view_main_page_card_title)
            )
        ), withId(R.id.feed_content_type_checkbox)
    )

    private val contentTypeRecycler = withId(R.id.content_types_recycler)

    fun scrollTo() {
        onView(contentTypeRecycler)
            .perform(swipeUp())
    }

    fun checkCheckboxFeaturedArticleTrue() {
        onView(checkboxFeaturedArticle)
            .check(matches(isChecked()))
    }

    fun checkCheckboxTopReadTrue() {
        onView(checkboxTopRead)
            .check(matches(isChecked()))
    }

    fun checkCheckboxPictureDayTrue() {
        onView(checkboxPictureDay)
            .check(matches(isChecked()))
    }

    fun checkCheckboxBecauseYouReadTrue() {
        onView(checkboxBecauseYouRead)
            .check(matches(isChecked()))
    }

    fun checkCheckboxInNewsTrue() {
        onView(checkboxInNews)
            .check(matches(isChecked()))
    }

    fun checkCheckboxOnThisDayTrue() {
        onView(checkboxOnThisDay)
            .check(matches(isChecked()))
    }

    fun checkCheckboxRandomizerTrue() {
        onView(checkboxRandomizer)
            .check(matches(isChecked()))
    }

    fun checkCheckboxTodayOnWikipediaTrue() {
        onView(checkboxTodayOnWikipedia)
            .check(matches(isChecked()))
    }

    companion object {
        inline operator fun invoke(crossinline block: ExploreFeed.() -> Unit) = ExploreFeed().block()
    }
}