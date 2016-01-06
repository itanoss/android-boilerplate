package kr.itanoss.androidboilerplate;

import android.app.Application;

public class DemoApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeComponent();
    }

    protected void initializeComponent() {
        component = DaggerApplicationComponent.builder()
                .demoApplicationModule(new DemoApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
