package com.godb.app.presentation.presenters;

import com.godb.app.ui.views.MvpView;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
