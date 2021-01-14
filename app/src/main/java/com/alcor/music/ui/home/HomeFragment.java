package com.alcor.music.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alcor.music.databinding.FragmentHomeBinding;
import com.alcor.music.model.Album;
import com.alcor.music.model.Artist;
import com.alcor.music.model.Track;
import com.alcor.music.adapter.AlbumAdapter;
import com.alcor.music.ui.viewmodel.AlbumViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    AlbumViewModel albumViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);

        AlbumAdapter adapter = new AlbumAdapter();
        adapter.setOnItemClickListener((view, position, transaction) -> {

        });
        binding.recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.recycler.setAdapter(adapter);

        albumViewModel = new ViewModelProvider(getActivity()).get(AlbumViewModel.class);
        albumViewModel.albumListMutable.observe(getActivity(), albums -> {
            adapter.list = albums;
            adapter.notifyDataSetChanged();
        });

        binding.search.setOnClickListener(v -> {
            //addData();
        });

        return binding.getRoot();
    }

    public void addData(){
        Album album = new Album("1","1","1","1","1","1","gs://alcor-87d33.appspot.com/music/homegrown.jpg","1","1","1",63,3500,4.8);
        Track track = new Track("1","1","1","1","1","1","1","1","1","1","1","1","1",1.2,3.6,28);
        Artist artist = new Artist("1","1","1","1","1","1",5.0, 100);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/music");

        ref.child("albums").push().setValue(album);
        ref.child("tracks").push().setValue(track);
        ref.child("artists").push().setValue(artist);
    }
}