package com.example.limmonica.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the text view of the Library
        TextView songsList = findViewById(R.id.library);
        // Set a click listener on it
        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent which sends the user to the Songs activity
                Intent songsListIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsListIntent);
            }
        });

        // Find the text view of the Albums
        TextView albumsGridView = findViewById(R.id.albums);
        // Set a click listener on it
        albumsGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent which sends the user to the Albums activity
                Intent albumsGridIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsGridIntent);
            }
        });

        // Find the text view of the Artists
        TextView artistsGridView = findViewById(R.id.artists);
        // Set a click listener on it
        artistsGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent which sends the user to the Artists activity
                Intent artistsGridIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(artistsGridIntent);
            }
        });
    }
}
