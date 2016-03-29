package com.godb.app.data;

import com.godb.app.data.api.ApiService;
import com.godb.app.data.api.ServiceFactory;
import com.godb.app.data.local.PreferencesHelper;
import com.godb.app.presentation.models.Announcement;
import rx.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
@Singleton
public class DataManager {
    ApiService apiService;
    PreferencesHelper preferencesHelper;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    public Observable<Announcement> getAnnouncements(String s) {
        if (apiService == null)
            apiService = ServiceFactory.createService(ApiService.class, ApiService.SERVICE_ENDPOINT);

        return Observable.from(Arrays.asList(Announcement.CREATOR.newArray(2)));
//                apiService.getAnnouncements(s)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
    }
}