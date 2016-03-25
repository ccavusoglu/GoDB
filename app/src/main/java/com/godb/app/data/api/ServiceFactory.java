package com.godb.app.data.api;

import retrofit2.Retrofit;

/**
 * Created by Q on 23.03.2016.
 */
public class ServiceFactory {
    public static <T> T createService(final Class<T> clazz, final String endPoint) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .build();

        return retrofit.create(clazz);
    }
}
