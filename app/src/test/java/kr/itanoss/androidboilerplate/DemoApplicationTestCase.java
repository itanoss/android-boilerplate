package kr.itanoss.androidboilerplate;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = 21)   // Alternative, currently API Level 23 is not supported
public class DemoApplicationTestCase {
}
