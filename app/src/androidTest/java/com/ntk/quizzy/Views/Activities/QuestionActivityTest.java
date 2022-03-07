package com.ntk.quizzy.Views.Activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.ntk.quizzy.R;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class QuestionActivityTest {

    @Test
    public void TestQuestionTitleIsAppears() {
         ActivityScenario QuestionActivity = ActivityScenario.launch(QuestionActivity.class); // Lunch QuestionActivity
         onView(withId(R.id.questitle)).check(matches(isDisplayed())); //Look at the Ques Title
    }

}