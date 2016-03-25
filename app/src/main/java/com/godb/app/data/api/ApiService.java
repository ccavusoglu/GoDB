package com.godb.app.data.api;

import com.godb.app.presentation.models.Announcement;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

/**
 * Created by Q on 23.03.2016.
 */
public interface ApiService {
    String SERVICE_ENDPOINT = "https://localhost/api";

    @GET("/users/{path}")
    Observable<List<Announcement>> getAnnouncements(@Path("announcements") String path);
}
