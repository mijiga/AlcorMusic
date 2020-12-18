package com.alcor.music.ui.viewmodel;

import android.app.Application;

import com.alcor.music.model.Constant;
import com.alcor.music.model.Track;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import static com.alcor.music.model.Constant.BY_ALBUM;
import static com.alcor.music.model.Constant.BY_ARTIST;
import static com.alcor.music.model.Constant.BY_GENRE;

public class TrackListViewModel extends AndroidViewModel {

    public MutableLiveData<ArrayList<Track>> trackListMutable = new MutableLiveData<>();

    private ArrayList<Track> trackList = new ArrayList<>();
    private ChildEventListener mChildEventListener;
    Gson gson = new Gson();

    public TrackListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Track>> getTrackList(int criteria, String value){
        String key = "artistID";
        if(criteria == BY_ARTIST){
            key = "artistID";
        }else if(criteria == BY_ALBUM){
            key = "albumID";
        }else if(criteria == BY_GENRE){
            key = "genreID";
        }

        System.out.println("this the ID: "+value);

        Query databaseQuery = FirebaseDatabase.getInstance().getReference().child(Constant.TRACKS_REF).orderByChild(key).equalTo(value);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Track track = snapshot.getValue(Track.class);
                System.out.println("the track:" + gson.toJson(track));
                if (track != null) {
                    track.setTrackID(snapshot.getKey());
                }
                trackList.add(track);
                trackListMutable.setValue(trackList);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Track track = snapshot.getValue(Track.class);
                if(track != null){
                    track.setTrackID(snapshot.getKey());
                }
                trackList.set(search(snapshot.getKey()), track);
                trackListMutable.setValue(trackList);
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

        databaseQuery.addChildEventListener(mChildEventListener);

        return trackListMutable;
    }

    public int search(String trackID){
        int pos = 0;
        for (Track track : trackList) {
            if(track.getAlbumID().equals(trackID)){
                pos = trackList.indexOf(track);
                break;
            }
        }
        return pos;
    }

}
