package com.godb.app.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.godb.app.R;
import com.godb.app.presentation.models.Announcement;
import com.godb.app.presentation.presenters.MainPresenter;
import com.godb.app.ui.adapters.AnnouncementsAdapter;
import com.godb.app.ui.views.MainMvpView;

import javax.inject.Inject;
import java.util.List;

public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainPresenter mMainPresenter;
    @Inject
    AnnouncementsAdapter mAnnouncementAdapter;

    @Bind(R.id.main_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        mRecyclerView.setAdapter(mAnnouncementAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainPresenter.attachView(this);
        mMainPresenter.loadAnnouncements();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMainPresenter.detachView();
    }

    /*****
     * MVP View methods implementation
     *****/

    @Override
    public void showAnnouncements(List<Announcement> announcements) {

    }
}
