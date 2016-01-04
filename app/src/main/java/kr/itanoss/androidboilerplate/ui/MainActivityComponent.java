package kr.itanoss.androidboilerplate.ui;

import dagger.Component;
import kr.itanoss.androidboilerplate.AbstractActivityComponent;
import kr.itanoss.androidboilerplate.ActivityModule;
import kr.itanoss.androidboilerplate.ApplicationComponent;
import kr.itanoss.androidboilerplate.PerActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface MainActivityComponent extends AbstractActivityComponent {
    void inject(MainActivity activity);
    void inject(MainActivityFragment fragment);
}
