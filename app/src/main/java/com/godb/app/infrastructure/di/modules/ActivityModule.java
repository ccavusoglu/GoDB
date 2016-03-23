package com.godb.app.infrastructure.di.modules;

import android.app.Activity;
import android.content.Context;
import com.godb.app.infrastructure.di.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }
}
