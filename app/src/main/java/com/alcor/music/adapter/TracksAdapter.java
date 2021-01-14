package com.alcor.music.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alcor.music.R;
import com.alcor.music.model.Track;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    public ArrayList<Track> list = new ArrayList<>();

    public TracksAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.track_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Track track = list.get(position);

        holder.trackNumberView.setText(track.getTrackNumber());
        holder.trackTitleView.setText(track.getTitle());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView trackNumberView;
        TextView trackTitleView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            trackNumberView = itemView.findViewById(R.id.trackNumber);
            trackTitleView = itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
