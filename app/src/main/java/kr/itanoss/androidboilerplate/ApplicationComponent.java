package kr.itanoss.androidboilerplate;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DemoApplicationModule.class)
public interface ApplicationComponent {
    // Field injections of any dependencies of the DemoApplication
    void inject(DemoApplication application);

    // Exported for child-components.
    Application application();
}
