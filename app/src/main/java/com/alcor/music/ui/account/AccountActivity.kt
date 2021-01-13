package com.alcor.music.ui.account

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alcor.music.R
import com.alcor.music.model.User
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        //val repository = UserRepository();

        //repository.getUser("q2NWnrW1ymTBL6nSBwGfHJo1Nnl1").observe(this, this::setupViews)

    }

    fun setupViews(user: User){
        name.text = user.name
        Glide.with(this)
                .load(Uri.parse(user.userImage))
                .centerCrop()
                .into(profile_photo)

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            //startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}