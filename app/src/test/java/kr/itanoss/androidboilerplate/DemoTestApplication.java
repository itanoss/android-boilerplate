package kr.itanoss.androidboilerplate;

import android.app.Application;

public class DemoTestApplication extends DemoApplication {

    private TestApplicationComponent component;

    @Override
    protected final void initializeComponent() {
        component = DaggerTestApplicationComponent.builder()
                .demoTestApplicationModule(new DemoTestApplicationModule(this))
                .build();
    }

    @Override
    public TestApplicationComponent getComponent() {
        return component;
    }

}
