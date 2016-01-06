package kr.itanoss.androidboilerplate;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        application = DemoTestApplication.class,
        sdk = 21)   // Alternative, currently API Level 23 is not supported
public abstract class DemoApplicationTestCase {
    @Before
    public void _init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
