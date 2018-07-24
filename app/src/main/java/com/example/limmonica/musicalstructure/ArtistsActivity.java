package com.example.limmonica.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        final ArrayList<Artist> artists = MusicDatabase.getInstance().getArtists();

        // Create a {@link ArtistAdapter} whose data source is a list of {@link Artist}. The adapter
        // creates grid items for each item in the grid.
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link GridView} with the view ID called gridview_element,
        // which is declared in the gridview layout file.
        GridView gridView = findViewById(R.id.gridview_element);

        // Make the {@link GridView} use the {@link ArtistAdapter} we created above, so that the
        // {@link GridView} will display grid items for each {@link Artist} in the grid.
        gridView.setAdapter(adapter);
    }
}
