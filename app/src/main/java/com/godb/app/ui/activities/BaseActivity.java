package com.godb.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.godb.app.GoDBApplication;
import com.godb.app.infrastructure.di.components.ActivityComponent;
import com.godb.app.infrastructure.di.components.DaggerActivityComponent;
import com.godb.app.infrastructure.di.modules.ActivityModule;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}

