package kr.itanoss.androidboilerplate;

import android.app.Application;
import android.view.View;

import javax.inject.Singleton;

import dagger.Component;
import kr.itanoss.androidboilerplate.service.Toaster;
import kr.itanoss.androidboilerplate.ui.MainActivity;
import kr.itanoss.androidboilerplate.ui.MainActivityFragment;

@Singleton
@Component(modules = DemoApplicationModule.class)
public interface ApplicationComponent {
    // Field injections of any dependencies of the DemoApplication
    void inject(DemoApplication application);

    void inject(MainActivity activity);
    void inject(MainActivityFragment fragment);
}
