package com.example.limmonica.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumsActivity extends AppCompatActivity {

    // Find & bind the {@link GridView} object in the view hierarchy of the {@link Activity} with
    // the variable. There should be a {@link GridView} with the view ID called gridview_element,
    // which is declared in the gridview.xml layout file.
    @BindView(R.id.gridview_element)
    GridView gridViewElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        // Bind the view using ButterKnife
        ButterKnife.bind(this);

        final List<Album> albums = MusicDatabase.getInstance().getAlbums();

        //Create a {@link AlbumAdapter} whose data source is a list of {@link Album}s. The adapter
        // creates a grid for each item in the list.
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Make the {@link GridView} use the {@link AlbumAdapter} we created above, so that the
        // {@link GridView} will display grid items for each {@link Album} in the list.
        gridViewElement.setAdapter(adapter);

        gridViewElement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent albumDetail = new Intent(AlbumsActivity.this, SongsActivity.class);
                albumDetail.putExtra("position", position);
                startActivity(albumDetail);
            }
        });
    }
}
