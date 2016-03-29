package com.godb.app.ui.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.godb.app.R;
import com.godb.app.GoDBApplication;
import com.godb.app.infrastructure.di.components.ActivityComponent;
import com.godb.app.infrastructure.di.components.DaggerActivityComponent;
import com.godb.app.infrastructure.di.modules.ActivityModule;
import com.godb.app.ui.fragments.EventsFragment;
import com.godb.app.ui.fragments.LoginFragment;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, EventsFragment.OnFragmentInteractionListener {
    private ActivityComponent mActivityComponent;

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        init();
    }

    protected void init() {
        mToolbar = (Toolbar) this.findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        NavigationView mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(GoDBApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                bringLoginFragment();
                return true;
            case R.id.action_settings:
                bringSettingsFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    void bringLoginFragment() {
// get fragment manager
        FragmentManager fm = getFragmentManager();

// add
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_placeholder, LoginFragment.newInstance());
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
// alternatively add it with a tag
// trx.add(R.id.your_placehodler, new YourFragment(), "detail");
//
//// replace
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.fragment_placeholder, new YourFragment());
//        ft.commit();
//
//// remove
//        Fragment fragment = fm.findFragmentById(R.id.your_placehodler);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.remove(fragment);
//        ft.commit();

        ft.addToBackStack("FragLogin");
        ft.commit();
    }

    void bringSettingsFragment() {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }


    @Override
    public void onFragmentInteraction(String id) {

    }
}

