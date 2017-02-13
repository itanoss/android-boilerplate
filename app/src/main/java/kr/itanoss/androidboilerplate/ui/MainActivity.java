package kr.itanoss.androidboilerplate.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kr.itanoss.androidboilerplate.DemoApplication;
import kr.itanoss.androidboilerplate.R;
import kr.itanoss.androidboilerplate.service.Toaster;

public class MainActivity extends AppCompatActivity {

    @Inject
    Toaster toaster;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ((DemoApplication)getApplication()).getComponent().inject(this);
    }

    @OnClick(R.id.fab)
    public void fabOnClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @OnClick(R.id.hello_world)
    public void clicked() {
        Observable.just(1, 2, 3, 4, 5)
                .reduce((a, b) -> a+b)
                .map(x -> x.toString())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(toaster::show);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            toaster.show("Here is a message of dependency!");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
