package kr.itanoss.androidboilerplate;

import javax.inject.Singleton;

import dagger.Component;
import kr.itanoss.androidboilerplate.ui.MainActivity;

@Singleton
@Component(modules = DemoApplicationModule.class)
public interface ApplicationComponent {
    // Field injections of any dependencies of the DemoApplication
    void inject(DemoApplication application);

    void inject(MainActivity activity);
}
