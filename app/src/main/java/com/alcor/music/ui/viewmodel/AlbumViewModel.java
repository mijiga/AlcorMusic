package com.alcor.music.ui.viewmodel;

import android.app.Application;

import com.alcor.music.model.Album;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AlbumViewModel extends AndroidViewModel {

    public MutableLiveData<ArrayList<Album>> albumListMutable = new MutableLiveData<>();
    private ArrayList<Album> albumList = new ArrayList<>();
    private ChildEventListener mChildEventListener;
    Gson gson = new Gson();
    
    public AlbumViewModel(@NonNull Application application) {
        super(application);
        //albumList.clear();
    }

    public LiveData<ArrayList<Album>> getAlbums(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/music/albums/");

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Album album = snapshot.getValue(Album.class);
                System.out.println("the album thou: "+gson.toJson(album));
                if (album != null) {
                    album.setAlbumID(snapshot.getKey());
                }
                albumList.add(album);
                albumListMutable.setValue(albumList);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //albumListMutable.notifyAll();
                Album album = snapshot.getValue(Album.class);
                album.setAlbumID(snapshot.getKey());
                albumList.set(search(snapshot.getKey()), album);

                albumListMutable.setValue(albumList);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        ref.addChildEventListener(mChildEventListener);

        return albumListMutable;
    }

    public int search(String albumID){
        int pos = 0;
        for (Album album : albumList) {
            if(album.getAlbumID().equals(albumID)){
                pos = albumList.indexOf(album);
                break;
            }
        }
        return pos;
    }
    
}
