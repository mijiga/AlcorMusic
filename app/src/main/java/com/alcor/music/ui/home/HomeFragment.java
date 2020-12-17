package com.alcor.music.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alcor.music.databinding.FragmentHomeBinding;
import com.alcor.music.model.Album;
import com.alcor.music.model.Artist;
import com.alcor.music.model.Track;
import com.alcor.music.ui.adapter.AlbumAdapter;
import com.alcor.music.ui.viewmodel.AlbumViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

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

        albumViewModel = new ViewModelProvider(this).get(AlbumViewModel.class);
        albumViewModel.getAlbums().observe(getViewLifecycleOwner(), this::setupAdapter);

//        binding.album1.setOnClickListener(v -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
//            navController.navigate(R.id.navigation_item_details);
//        });
//
//        binding.album2.setOnClickListener(v -> {
//            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
//            navController.navigate(R.id.navigation_item_details);
//        });

        binding.search.setOnClickListener(v -> {
            Album album = new Album("1","1","1","1","1","1","1","1","1","1",63,3500,4.8);
            Track track = new Track("1","1","1","1","1","1","1","1","1","1","1",1.2,3.6,28);
            Artist artist = new Artist("1","1","1","1","1","1",5.0, 100);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/music");

//            ref.child("albums").push().setValue(album);
//            ref.child("tracks").push().setValue(track);
//            ref.child("artists").push().setValue(artist);
//
//            Gson gson = new Gson();
//            System.out.println("album: "+gson.toJson(album));
//            System.out.println("track: "+gson.toJson(track));
//            System.out.println("artist: "+gson.toJson(artist));
        });

        return binding.getRoot();
    }

    public void setupAdapter(ArrayList<Album> albums){
        AlbumAdapter adapter = new AlbumAdapter(albums);
        binding.recycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.recycler.setAdapter(adapter);
    }
}