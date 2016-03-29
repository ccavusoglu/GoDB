package com.godb.app.ui.views;

import com.godb.app.presentation.models.Announcement;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public interface MainMvpView extends MvpView {
    void showAnnouncements(Announcement announcements);
}
