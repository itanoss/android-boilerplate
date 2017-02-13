package kr.itanoss.androidboilerplate.ui;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.fakes.RoboMenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.itanoss.androidboilerplate.DemoApplicationTestCase;
import kr.itanoss.androidboilerplate.DemoTestApplication;
import kr.itanoss.androidboilerplate.R;
import kr.itanoss.androidboilerplate.service.Toaster;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainActivityUnitTest extends DemoApplicationTestCase {

    @Inject
    Toaster toaster;
    private MainActivity activity;

    @BindView(R.id.hello_world)
    View helloWorld;

    @Before
    public void setup() throws Exception {
        ((DemoTestApplication) RuntimeEnvironment.application).getComponent().inject(this);

        activity = Robolectric.setupActivity(MainActivity.class);
        ButterKnife.bind(this, activity);
    }

    @Test
    public void clickingSettingsMenu_toastMessageShouldBeShown() throws Exception {
        activity.onOptionsItemSelected(new RoboMenuItem(R.id.action_settings));

        verify(toaster, times(1)).show(eq("Here is a message of dependency!"));
    }

    @Test
    public void clickingHelloWorldText_toastMessageShouldBeShown() throws Exception {
        helloWorld.performClick();

        verify(toaster).show(eq("15"));
    }
}