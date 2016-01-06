package kr.itanoss.androidboilerplate.service;

import android.app.Application;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Toaster {
    private final Application application;

    @Inject
    public Toaster(Application application) {
        this.application = application;
    }

    public void show(String message) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show();
    }
}
