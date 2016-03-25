package com.godb.app.infrastructure.di.components;

import com.godb.app.infrastructure.di.modules.ActivityModule;
import com.godb.app.infrastructure.di.scopes.PerActivity;
import com.godb.app.ui.activities.MainActivity;
import dagger.Component;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
