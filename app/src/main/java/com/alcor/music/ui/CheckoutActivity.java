package com.alcor.music.ui;

import android.os.Bundle;

import com.alcor.music.R;
import com.alcor.music.databinding.ActivityCheckoutBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);


    }


}
