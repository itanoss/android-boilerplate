package kr.itanoss.androidboilerplate.ui;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.itanoss.androidboilerplate.BuildConfig;
import kr.itanoss.androidboilerplate.R;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityFunctionalTest {

    private MainActivity activity;

    @BindView(R.id.hello_world)
    View helloWorld;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);
        ButterKnife.bind(this, activity);
    }

    @Test
    public void clickingSettingsMenu_toastMessageShouldBeShown() throws Exception {
        activity.onOptionsItemSelected(new RoboMenuItem(R.id.action_settings));
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Here is a message of dependency!");
    }


    @Test
    public void clickingHelloWorldText_toastMessageShouldBeShown() throws Exception {
        helloWorld.performClick();
        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("15");
    }
}