package com.example.limmonica.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistsActivity extends AppCompatActivity {

    // Find & bind the {@link GridView} object in the view hierarchy of the {@link Activity} with
    // the variable. There should be a {@link GridView} with the view ID called gridview_element,
    // which is declared in the gridview layout file.
    @BindView(R.id.gridview_element)
    GridView gridViewElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        // Bind the view using ButterKnife
        ButterKnife.bind(this);

        final List<Artist> artists = MusicDatabase.getInstance().getArtists();

        // Create a {@link ArtistAdapter} whose data source is a list of {@link Artist}. The adapter
        // creates grid items for each item in the grid.
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        // Make the {@link GridView} use the {@link ArtistAdapter} we created above, so that the
        // {@link GridView} will display grid items for each {@link Artist} in the grid.
        gridViewElement.setAdapter(adapter);
    }
}
