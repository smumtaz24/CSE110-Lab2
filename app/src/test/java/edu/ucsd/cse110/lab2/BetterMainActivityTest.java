package edu.ucsd.cse110.lab2;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {

    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            var one_button = activity.findViewById(R.id.btn_one);
            var plus_button = activity.findViewById(R.id.btn_plus);
            var equals_button = activity.findViewById(R.id.btn_equals);
            one_button.performClick();
            plus_button.performClick();
            one_button.performClick();
            equals_button.performClick();

            TextView display = activity.findViewById(R.id.display);
            assertEquals("2", display.getText());
        });
    }

}
