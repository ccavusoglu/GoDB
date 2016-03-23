package com.godb.app.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.godb.app.R;
import com.godb.app.presentation.models.Announcement;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccavusoglu on 23.03.2016.
 */
public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementViewHolder> {

    private List<Announcement> mAnnouncements;

    @Inject
    public AnnouncementsAdapter() {
        mAnnouncements = new ArrayList<>();
    }

    public void setAnnouncements(List<Announcement> announcements) {
        mAnnouncements = announcements;
    }

    @Override
    public AnnouncementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_announcement, parent, false);
        return new AnnouncementViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnnouncementViewHolder holder, int position) {
        Announcement announcement = mAnnouncements.get(position);
//        holder.hexColorView.setBackgroundColor(Color.parseColor(announcement.profile.hexColor));
//        holder.nameTextView.setText(String.format("%s %s",
//                announcement.profile.name.first, announcement.profile.name.last));
//        holder.emailTextView.setText(announcement.profile.email);
    }

    @Override
    public int getItemCount() {
        return mAnnouncements.size();
    }

    class AnnouncementViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.view_hex_color) View hexColorView;
        @Bind(R.id.text_name)
        TextView nameTextView;
        @Bind(R.id.text_email) TextView emailTextView;

        public AnnouncementViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
