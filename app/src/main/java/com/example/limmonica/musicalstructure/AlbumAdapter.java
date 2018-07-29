package com.example.limmonica.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    AlbumAdapter(Context context, List<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Initialise the holder
        ViewHolder holder;

        // If there is no existing view being reused
        if (convertView == null) {
            // Inflate the view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.albums_item, parent, false);
            // Setup the holder
            holder = new ViewHolder(convertView);
            // Store the holder tag with the convertView
            convertView.setTag(holder);
        } else {
            // Otherwise use the holder instead of calling findViewById() on resource every time
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Album} object located at this position in the grid
        Album currentAlbum = getItem(position);

        // Assign values if the object currentAlbum is not null
        if (currentAlbum != null) {
            // Get the layout elements from the ViewHolder
            // Get the album artist name from the currentAlbum object and set this text on
            // the album_artist_text_view
            holder.albumArtist.setText(currentAlbum.getAlbumArtistName());
            // Get the album title from the currentAlbum object and set this text on
            // the album_name_text_view
            holder.albumTitle.setText(currentAlbum.getAlbumName());
            // Get and store the album year as integer from the currentAlbum object
            int albumYear = currentAlbum.getAlbumYear();
            // Transform the album year integer into a string
            String albumYearToString = Integer.toString(albumYear);
            // Set the album year text on the album_year_text_view
            holder.albumYear.setText(albumYearToString);
            // Get the album cover image from the currentAlbum object and set this image on
            // the album_cover_image_view
            holder.albumCover.setImageResource(currentAlbum.getAlbumResourceId());
            // Make sure the convertView is visible
            holder.albumCover.setVisibility(View.VISIBLE);
        }

        // Return the whole grid item layout containing 1 TextView and 1 ImageView so that it can be shown in the GridView
        return convertView;
    }

    /**
     * Create a class {@link ViewHolder} to hold/cache the exact set of views that we need.
     * A {@link ViewHolder} object stores each of the component views inside the tag field of the
     * Layout, so it can immediately be accessed without the need to look them up repeatedly.
     */
    static class ViewHolder {
        // Find and bind with the variable the TextView in the albums_item.xml layout with the ID
        // album_artist_text_view
        @BindView(R.id.album_artist_text_view)
        TextView albumArtist;
        // Find and bind with the variable the TextView in the album_item.xml layout with the ID
        // album_name_text_view
        @BindView(R.id.album_name_text_view)
        TextView albumTitle;
        // Find and bind with the variable the TextView in the album_item.xml layout with the ID
        // album_year_text_view
        @BindView(R.id.album_year_text_view)
        TextView albumYear;
        // Find and bind with the variable the ImageView in the album_item.xml layout with the ID
        // album_cover_image_view
        @BindView(R.id.album_cover_image_view)
        ImageView albumCover;

        ViewHolder(View view) {
            // Pass the view to ButterKnife to bind it
            ButterKnife.bind(this, view);
        }
    }
}