package kr.itanoss.androidboilerplate;

import android.app.Application;
import android.widget.Toast;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kr.itanoss.androidboilerplate.service.Toaster;

import static org.mockito.Mockito.mock;

@Module
public class DemoTestApplicationModule {
    private final Application application;

    public DemoTestApplicationModule(Application application) {
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
        return mock(Toaster.class);
    }
}
