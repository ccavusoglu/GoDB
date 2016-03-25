package com.godb.app;

import android.app.Application;
import android.content.Context;
import com.example.godb.app.BuildConfig;
import com.godb.app.infrastructure.di.components.ApplicationComponent;
import com.godb.app.infrastructure.di.components.DaggerApplicationComponent;
import com.godb.app.infrastructure.di.modules.ApplicationModule;
import timber.log.Timber;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public class GoDBApplication extends Application {
    ApplicationComponent mApplicationComponent;

    public static GoDBApplication get(Context context) {
        return (GoDBApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            //Fabric.with(this, new Crashlytics());
        }
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
