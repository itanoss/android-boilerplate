package kr.itanoss.androidboilerplate.ui;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowToast;

import javax.inject.Inject;
import javax.inject.Singleton;

import kr.itanoss.androidboilerplate.DemoApplicationTestCase;
import kr.itanoss.androidboilerplate.DemoTestApplication;
import kr.itanoss.androidboilerplate.R;
import kr.itanoss.androidboilerplate.service.Toaster;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainActivityUnitTest extends DemoApplicationTestCase {

    @Inject
    Toaster toaster;

    @Before
    public void setup() throws Exception {
        ((DemoTestApplication) RuntimeEnvironment.application).getComponent().inject(this);
    }

    @Test
    public void clickingSettingsMenu_toastMessageshouldBeShown() throws Exception {
        final MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.onOptionsItemSelected(new RoboMenuItem(R.id.action_settings));
//        assertThat(ShadowToast.getTextOfLatestToast()).isEqualTo("Here is a message of dependency!");
        verify(toaster, times(1)).show(eq("Here is a message of dependency!"));
    }
}