package kr.itanoss.androidboilerplate.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowToast;

import kr.itanoss.androidboilerplate.BuildConfig;
import kr.itanoss.androidboilerplate.R;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = 21)   // Alternative, currently API Level 23 is not supported
public class MainActivityFunctionalTest {

    @Test
    public void clickingSettingsMenu_toastMessageshouldBeShown() throws Exception {
        final MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.onOptionsItemSelected(new RoboMenuItem(R.id.action_settings));
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Here is a message of dependency!");
    }
}