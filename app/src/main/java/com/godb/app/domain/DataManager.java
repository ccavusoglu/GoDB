package com.godb.app.domain;

import com.godb.app.domain.api.ApiService;
import com.godb.app.domain.api.ServiceFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    public Observable getAnnouncements(String s) {
        ApiService service = ServiceFactory.createService(ApiService.class, ApiService.SERVICE_ENDPOINT);

        return service.getAnnouncements(s)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}