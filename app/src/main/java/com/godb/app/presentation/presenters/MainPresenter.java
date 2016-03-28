package com.godb.app.presentation.presenters;

import com.godb.app.data.DataManager;
import com.godb.app.presentation.models.Announcement;
import com.godb.app.ui.views.MainMvpView;
import rx.Subscriber;
import rx.Subscription;
import timber.log.Timber;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public class MainPresenter extends BasePresenter<MainMvpView> {
    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadAnnouncements() {
        checkViewAttached();
        mSubscription = mDataManager.getAnnouncements("")
                .subscribe(new Subscriber<List<Announcement>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error loading the ribots.");
                    }

                    @Override
                    public void onNext(List<Announcement> announcements) {
                        if (announcements.isEmpty()) {
                            getMvpView().showAnnouncements(announcements);
                        } else {
                            getMvpView().showAnnouncements(announcements);
                        }
                    }
                });
    }
}
