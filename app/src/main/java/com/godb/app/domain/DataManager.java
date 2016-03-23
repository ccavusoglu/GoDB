package com.godb.app.domain;

import rx.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@Singleton
public class DataManager {
    @Inject
    public DataManager() {
    }

    public Observable getAnnouncements() {
        return null;
    }
}