package com.example.limmonica.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Find and bind the view which displays the Library text view with the variable
    @BindView(R.id.library)
    TextView songsList;
    // Find and bind the view which displays the Albums text view with the variable
    @BindView(R.id.albums)
    TextView albumsGridView;
    // Find and bind the view which displays the Artists text view with the variable
    @BindView(R.id.artists)
    TextView artistsGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the views using ButterKnife
        ButterKnife.bind(this);

        // Set a click listener on it
        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent which sends the user to the Songs activity
                Intent songsListIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsListIntent);
            }
        });

        // Set a click listener on it
        albumsGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an explicit intent which sends the user to the Albums activity
                Intent albumsGridIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsGridIntent);
            }
        });

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
