package kr.itanoss.androidboilerplate;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kr.itanoss.androidboilerplate.service.Toaster;

@Module
public class DemoApplicationModule {
    private final Application application;

    public DemoApplicationModule(Application application) {
        this.application = application;
    }

    /**
     * Expose the application to the graph.
     */
    @Provides
    @Singleton
    Application application() {
        return application;
    }

    @Provides @Singleton
    Toaster toaster() {
        return new Toaster(application);
    }
}
