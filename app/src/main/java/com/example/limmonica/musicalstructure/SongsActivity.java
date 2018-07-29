package com.example.limmonica.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongsActivity extends AppCompatActivity {

    // Find & bind the {@link ListView} object in the view hierarchy of the {@link Activity} with
    // the variable. There should be a {@link ListView} with the view ID called listview_element,
    // which is declared in the songs_list.xml layout file.
    @BindView(R.id.listview_element)
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        // Bind the view using ButterKnife
        ButterKnife.bind(this);

        final List<Song> songs;
        // Get the album position sent through the intent
        int albumPosition = getIntent().getIntExtra("position", -1);
        // If default value
        if (albumPosition < 0)
            // Display all library
            songs = MusicDatabase.getInstance().getSongs();
            // Else display the album's library at the selected position
        else songs = MusicDatabase.getInstance().getAlbums().get(albumPosition).getSongs();

        // Create a {@link SongAdapter} whose data source is a list of {@link Song}. The adapter
        // creates list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        // Set a click listener on each item of the list to display the detail page of the song
        // Pass the information of the clicked song to the {@link NowPlaying} in order to display
        // the information of that respective song.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Song clickedSong = songs.get(position);
                Intent songDetail = new Intent(SongsActivity.this, NowPlaying.class);
                songDetail.putExtra("clickedSong", clickedSong);
                startActivity(songDetail);
            }
        });
    }
}