package com.godb.app.infrastructure.di.modules;

import android.app.Application;
import android.content.Context;
import com.godb.app.domain.DataManager;
import com.godb.app.infrastructure.di.scopes.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    DataManager provideDataManager() {
        return new DataManager();
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
}
