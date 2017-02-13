package kr.itanoss.androidboilerplate;

import android.app.Application;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import kr.itanoss.androidboilerplate.network.YahooQueryProvider;
import kr.itanoss.androidboilerplate.service.Toaster;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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

    @Provides
    @Singleton
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Provides
    @Singleton
    YahooQueryProvider yahooQueryProvider(Retrofit retrofit) {
        return retrofit.create(YahooQueryProvider.class);
    }

    private static class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {


    }
}
