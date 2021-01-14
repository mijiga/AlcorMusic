package com.alcor.music.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.alcor.music.R
import com.alcor.music.adapter.AlbumAdapter
import com.alcor.music.model.Album
import com.alcor.music.model.Artist
import com.alcor.music.model.Track
import com.alcor.music.ui.viewmodel.AlbumViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var adapter: AlbumAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    private fun setupViews(){
        search.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.searchFragment)
        }

        //---Setup adapter start
        adapter = AlbumAdapter()
        adapter.setOnItemClickListener { view, position, album ->  }
        recycler.layoutManager = GridLayoutManager(context, 2)
        recycler.adapter = adapter

        val albumViewModel : AlbumViewModel by activityViewModels();
        albumViewModel.albumListMutable.observe(viewLifecycleOwner, Observer {
            System.out.println(it[0].artistName + " well then?")
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
        //---Setup adapter end

    }

    fun addData() {
        val album = Album("1", "1", "1", "1", "1", "1", "gs://alcor-87d33.appspot.com/music/homegrown.jpg", "1", "1", "1", 63, 3500, 4.8)
        val track = Track("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", 1.2, 3.6, 28)
        val artist = Artist("1", "1", "1", "1", "1", "1", 5.0, 100)
        val ref = FirebaseDatabase.getInstance().getReference("/music")
        ref.child("albums").push().setValue(album)
        ref.child("tracks").push().setValue(track)
        ref.child("artists").push().setValue(artist)
    }
}