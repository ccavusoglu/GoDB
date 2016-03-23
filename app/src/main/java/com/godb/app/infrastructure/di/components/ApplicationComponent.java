package com.godb.app.infrastructure.di.components;

import com.godb.app.infrastructure.di.modules.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

}
