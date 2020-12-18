package com.alcor.music.ui.itemdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alcor.music.R;
import com.alcor.music.databinding.ActivityCheckoutBinding;
import com.alcor.music.databinding.FragmentItemDetailsBinding;
import com.alcor.music.model.Album;
import com.alcor.music.model.Track;
import com.alcor.music.ui.adapter.TracksAdapter;
import com.alcor.music.ui.viewmodel.TrackListViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import static com.alcor.music.model.Constant.BY_ALBUM;

public class ItemDetailsFragment extends Fragment {

    FragmentItemDetailsBinding binding;
    Album album;
    Gson gson = new Gson();
    TrackListViewModel trackListViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        String bundleStr = bundle.getString("album");
        if(bundleStr != null && !bundleStr.isEmpty()){
            album = gson.fromJson(bundleStr, Album.class);
        }

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentItemDetailsBinding.inflate(inflater);

        trackListViewModel = new ViewModelProvider(getActivity()).get(TrackListViewModel.class);

        if(album != null){
            setUpViews(album);
            setupTrackList(BY_ALBUM, album.getAlbumID());
        }

        return binding.getRoot();
    }

    private void setUpViews(Album album){
        binding.title.setText(album.getName());
        binding.buy.setOnClickListener(v -> createPaymentDialog(album.getName(), album.getPrice(), album.getAlbumID()).show());
    }

    private void setupTrackList(int criteria, String value){
        TracksAdapter adapter = new TracksAdapter();
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycler.setAdapter(adapter);

        trackListViewModel.getTrackList(criteria, value).observe(getActivity(), new Observer<ArrayList<Track>>() {
            @Override
            public void onChanged(ArrayList<Track> tracks) {
                adapter.list = tracks;
                adapter.notifyDataSetChanged();
            }
        });
    }

    public BottomSheetDialog createPaymentDialog(String title, int price, String itemID){
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.activity_checkout,null);
        ActivityCheckoutBinding dialogBinding = ActivityCheckoutBinding.bind(dialogView);
        dialogBinding.title.setText(title);

        dialog.setContentView(dialogView);

        return dialog;
    }

}
