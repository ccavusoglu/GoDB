package com.godb.app.infrastructure.di.components;

import com.godb.app.data.DataManager;
import com.godb.app.data.local.PreferencesHelper;
import com.godb.app.infrastructure.di.modules.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    DataManager dataManager();

    PreferencesHelper preferencesHelper();
}
