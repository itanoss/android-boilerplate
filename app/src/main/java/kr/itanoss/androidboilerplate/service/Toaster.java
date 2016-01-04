package kr.itanoss.androidboilerplate.service;

import android.app.Activity;
import android.widget.Toast;

import javax.inject.Inject;

import kr.itanoss.androidboilerplate.PerActivity;

@PerActivity
public class Toaster {

    private final Activity activity;

    @Inject
    public Toaster(Activity activity) {
        this.activity = activity;
    }


    public void show(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
