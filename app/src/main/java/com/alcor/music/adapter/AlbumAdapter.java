package com.alcor.music.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alcor.music.R;
import com.alcor.music.helper.GlideApp;
import com.alcor.music.model.Album;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    public ArrayList<Album> list = new ArrayList<>();
    private Context context;
    private onItemClickListener mItemClickListener;
    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

    public AlbumAdapter() {

    }

    public AlbumAdapter(ArrayList<Album> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.album_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = list.get(position);

        holder.titleView.setText(album.getName());
        holder.subTextView.setText(album.getArtistName());
        StorageReference imageRef = firebaseStorage.getReferenceFromUrl(album.getThumbnail());
        System.out.println("the image ref"+imageRef);
        GlideApp.with(context)
                .load(imageRef)
                .into(holder.imageView);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView;
        TextView subTextView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleView = itemView.findViewById(R.id.title);
            subTextView = itemView.findViewById(R.id.subText);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClickListener(view, getAdapterPosition(), list.get(getAdapterPosition()));

                Album album = list.get(getAdapterPosition());
                Bundle bundle = new Bundle();
                Gson gson = new Gson();
                bundle.putSerializable("album", gson.toJson(album));
                NavController navController = Navigation.findNavController((AppCompatActivity)context, R.id.nav_host_fragment);
                navController.navigate(R.id.navigation_item_details, bundle);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(onItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface onItemClickListener {
        void onItemClickListener(View view, int position, Album album);
    }

}
