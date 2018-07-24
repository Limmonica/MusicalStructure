package com.example.limmonica.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link AlbumAdapter} is an {@link ArrayAdapter} that can provide the layout for each grid item
 * based on a data source, which is a list of {@link Album} objects.
 */

class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * Create a new {@link AlbumAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param albums  is the list of {@link Album}s to be displayed.
     */
    AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.albums_item, parent, false);
        }

        // Get the {@link Album} object located at this position in the grid
        Album currentAlbum = getItem(position);

        // Find the TextView in the albums_item.xml layout with the ID album_artist_text_view
        TextView albumArtistTextView = listItemView.findViewById(R.id.album_artist_text_view);
        // Get the Album Artist name from the currentAlbum object and set this text on the album_artist_text_view
        assert currentAlbum != null;
        albumArtistTextView.setText(currentAlbum.getAlbumArtistName());

        // Find the TextView in the albums_item.xml layout with the ID album_name_text_view
        TextView albumNameTextView = listItemView.findViewById(R.id.album_name_text_view);
        // Get the Album name from the currentAlbum object and set this text on the album_name_text_view
        albumNameTextView.setText(currentAlbum.getAlbumName());

        // Find the TextView in the albums_item.xml layout with the ID album_year_text_view
        TextView albumYearTextView = listItemView.findViewById(R.id.album_year_text_view);
        // Get the Album release year from the currentAlbum object
        int albumYear = currentAlbum.getAlbumYear();
        // Transform the album release year from integer to string
        String albumYearToString = Integer.toString(albumYear);
        // Set the album release year on the album_year_text_view
        albumYearTextView.setText(albumYearToString);

        // Find the ImageView in the albums_item.xml layout with the ID album_image_view
        ImageView albumImageView = listItemView.findViewById(R.id.album_image_view);
        // Get the Album cover image from the currentAlbum object and set this resource on the album_image_view
        albumImageView.setImageResource(currentAlbum.getAlbumResourceId());
        // Make sure the view is visible
        albumImageView.setVisibility(View.VISIBLE);

        // Return the whole grid item layout containing 1 TextView and 1 ImageView so that it can be shown in the GridView
        return listItemView;
    }
}