package com.example.limmonica.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        final ArrayList<Album> albums = MusicDatabase.getInstance().getAlbums();

        //Create a {@link AlbumAdapter} whose data source is a list of {@link Album}s. The adapter
        // creates a grid for each item in the list.
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // Find the {@link GridView} object in the view hierarchy of the {@link Activity}. There
        // should be a {@link GridView} with the view ID called gridview_element, which is
        // declared in the gridview.xml layout file.
        GridView gridView = findViewById(R.id.gridview_element);

        // Make the {@link GridView} use the {@link AlbumAdapter} we created above, so that the
        // {@link GridView} will display grid items for each {@link Album} in the list.
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent albumDetail = new Intent(AlbumsActivity.this, SongsActivity.class);
                albumDetail.putExtra("position", position);
                startActivity(albumDetail);
            }
        });
    }
}
