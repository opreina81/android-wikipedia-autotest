package org.wikipedia.espresso_test.mobile.screens

import android.text.method.PasswordTransformationMethod
import androidx.appcompat.widget.AppCompatTextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.instanceOf
import org.wikipedia.R
import org.wikipedia.views.PlainPasteEditText

class LoginScreen {
    private val seePassword = allOf(
        anyOf(
            withContentDescription("Показать пароль"),
            withContentDescription("Show password")
        ), isDescendantOfA(withId(R.id.create_account_password_input))
    )

    private val editTextPasswordField = allOf(
        instanceOf(PlainPasteEditText::class.java),
        isDescendantOfA(withId(R.id.create_account_password_input))
    )

    private val editTextLoginField = allOf(
        instanceOf(PlainPasteEditText::class.java),
        isDescendantOfA(withId(R.id.create_account_username))
    )

    private val errorMessage = allOf(
        instanceOf(AppCompatTextView::class.java), withText(R.string.create_account_password_error)
    )

    private val buttonSubmitMatcher = withId(R.id.create_account_submit_button)

    private val color = R.color.red700

    fun checkPasswordHidden(text: CharSequence) {
        onView(editTextPasswordField)
            .check(
                matches(
                    withText(
                        PasswordTransformationMethod().getTransformation(text, null).toString()
                    )
                )
            )
    }

    fun clickPasswordField() {
        onView(editTextPasswordField)
            .perform(click())
    }

    fun clickSeePassword() {
        onView(seePassword)
            .perform(click())
    }

    fun typeTextToLoginFiled(text: String) {
        onView(editTextLoginField)
            .perform(typeText(text))
    }

    fun typeTextToPasswordFiled(text: String) {
        onView(editTextPasswordField)
            .perform(typeText(text))
    }

    fun checkTextOnPasswordFiled(text: String) {
        onView(editTextPasswordField)
            .check(matches(withText(text)))
    }

    fun clickButtonSubmitMatcher() {
        onView(buttonSubmitMatcher)
            .perform(click())
    }

    fun redErrorMessageAppeared() {
        onView(errorMessage)
            .check(
                matches(
                    allOf(
                        isDisplayed(), hasTextColor(color)
                    )
                )
            )
    }

    companion object {
        inline operator fun invoke(crossinline block: LoginScreen.() -> Unit) =
            LoginScreen().block()
    }
}
