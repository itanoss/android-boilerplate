package kr.itanoss.androidboilerplate.ui;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowToast;

import kr.itanoss.androidboilerplate.DemoApplicationTestCase;
import kr.itanoss.androidboilerplate.R;

import static org.assertj.core.api.Assertions.assertThat;

public class MainActivityTest extends DemoApplicationTestCase {

    @Test
    public void clickingSettingsMenu_toastMessageshouldBeShown() throws Exception {
        final MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.onOptionsItemSelected(new RoboMenuItem(R.id.action_settings));
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Here is a message of dependency!");
    }
}