package kr.itanoss.androidboilerplate;

import javax.inject.Singleton;

import dagger.Component;
import kr.itanoss.androidboilerplate.ui.MainActivityUnitTest;

@Singleton
@Component(modules = DemoTestApplicationModule.class)
public interface TestApplicationComponent extends ApplicationComponent {
    void inject(MainActivityUnitTest mainActivityUnitTest);
    // Add more unit tests
}
