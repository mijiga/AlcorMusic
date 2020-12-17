package com.alcor.music.ui.itemdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alcor.music.databinding.FragmentItemDetailsBinding;
import com.alcor.music.ui.CheckoutActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ItemDetailsFragment extends Fragment {

    FragmentItemDetailsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentItemDetailsBinding.inflate(inflater);

        binding.buy.setOnClickListener(v -> startActivity(new Intent(getContext(), CheckoutActivity.class)));

        return binding.getRoot();
    }

    public void setUpViews(){

    }

}
