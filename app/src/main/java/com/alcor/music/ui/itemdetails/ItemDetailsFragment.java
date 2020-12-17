package com.alcor.music.ui.itemdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alcor.music.R;
import com.alcor.music.databinding.ActivityCheckoutBinding;
import com.alcor.music.databinding.FragmentItemDetailsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ItemDetailsFragment extends Fragment {

    FragmentItemDetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentItemDetailsBinding.inflate(inflater);

        binding.buy.setOnClickListener(v -> createTXNEditDialog().show());

        return binding.getRoot();
    }

    public BottomSheetDialog createTXNEditDialog(){
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dialogView = inflater.inflate(R.layout.activity_checkout,null);
        ActivityCheckoutBinding dialogBinding = ActivityCheckoutBinding.bind(dialogView);
        dialogBinding.title.setText("The Book of Eli");

        dialog.setContentView(dialogView);

        return dialog;
    }

}
