package com.alcor.music.ui.itemdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alcor.music.R;
import com.alcor.music.databinding.ActivityCheckoutBinding;
import com.alcor.music.databinding.FragmentItemDetailsBinding;
import com.alcor.music.model.Album;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemDetailsFragment extends Fragment {

    FragmentItemDetailsBinding binding;
    Album album;
    Gson gson = new Gson();

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

        if(album != null){
            setUpViews(album);
        }

        return binding.getRoot();
    }

    private void setUpViews(Album album){
        binding.title.setText(album.getName());
        binding.buy.setOnClickListener(v -> createPaymentDialog().show());
    }

    public BottomSheetDialog createPaymentDialog(){
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.activity_checkout,null);
        ActivityCheckoutBinding dialogBinding = ActivityCheckoutBinding.bind(dialogView);
        dialogBinding.title.setText("The Book of Eli");

        dialog.setContentView(dialogView);

        return dialog;
    }

}
