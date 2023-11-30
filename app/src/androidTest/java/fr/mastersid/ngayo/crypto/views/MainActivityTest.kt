package fr.mastersid.ngayo.crypto.views
import androidx.test.core.app.launchActivity
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import fr.mastersid.ngayo.crypto.R


import org.junit.Test
@MediumTest
class MainActivityTest{
    @Test
    fun verify_that_when_the_user_enters_Hello_world_in_the_text_field_the_text_Uryyb_jbeyq_is_displayed(){
        launchActivity<MainActivity>()
        onView(withId(R.id.editTextInputShift)).perform(typeText("13"))
        Thread.sleep(2000)

        onView(withId(R.id.buttonEncryptShift)).perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.editTextInput)).perform(typeText("Hello world"))
        Thread.sleep(2000)

        onView(withId(R.id.buttonEncrypt)).perform(click())
        Thread.sleep(2000)

        onView(withId(R.id.ecryptedText)).check(matches(withText("Uryyb jbeyq")))
        Thread.sleep(2000)
    }
}