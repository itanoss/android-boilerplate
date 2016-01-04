package kr.itanoss.androidboilerplate.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.itanoss.androidboilerplate.ActivityModule;
import kr.itanoss.androidboilerplate.DemoApplication;
import kr.itanoss.androidboilerplate.R;
import kr.itanoss.androidboilerplate.service.Toaster;

public class MainActivity extends AppCompatActivity {

    @Inject
    Toaster toaster;
    private MainActivityComponent component;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.fab) FloatingActionButton fab;

    public MainActivityComponent getComponent() {
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // DI with dagger
        component = DaggerMainActivityComponent.builder()
                .applicationComponent(((DemoApplication) getApplication()).getComponent())
                .activityModule(new ActivityModule(this))
                .build();
        component.inject(this);

        setContentView(R.layout.activity_main);

        // DI with butterknife
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.fab)
    public void fabOnClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
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
