package kr.itanoss.androidboilerplate;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,
        application = DemoTestApplication.class)
public abstract class DemoApplicationTestCase {
    @Before
    public void _init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
