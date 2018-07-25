package com.example.limmonica.musicalstructure;

import android.app.Activity;
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

        // Initialise the viewHolder
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.albums_item, parent, false);
            // setup the viewHolder
            viewHolder = new ViewHolder();
            // Find the TextView in the albums_item.xml layout with the ID album_artist_text_view
            viewHolder.albumArtist = convertView.findViewById(R.id.album_artist_text_view);
            // Find the TextView in the album_item.xml layout with the ID album_name_text_view
            viewHolder.albumTitle = convertView.findViewById(R.id.album_name_text_view);
            // Find the TextView in the album_item.xml layout with the ID album_year_text_view
            viewHolder.albumYear = convertView.findViewById(R.id.album_year_text_view);
            // Find the ImageView in the album_item.xml layour with the ID album_image_view
            viewHolder.albumCover = convertView.findViewById(R.id.album_image_view);
            // store the holder tag with the view
            convertView.setTag(viewHolder);
        } else {
            // use the viewHolder instead of calling findViewById() on resource every time
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Album} object located at this position in the grid
        Album currentAlbum = getItem(position);

        // Assign values if the object currentAlbum is not null
        if (currentAlbum != null) {
            // get the layout elements from the ViewHolder
            // get the album artist name from the currentAlbum object and set this text on the album_artist_text_view
            viewHolder.albumArtist.setText(currentAlbum.getAlbumArtistName());
            // get the album title from the currentAlbum object and set this text on the album_name_text_view
            viewHolder.albumTitle.setText(currentAlbum.getAlbumName());
            // get and store the album year as integer from the currentAlbum object
            int albumYear = currentAlbum.getAlbumYear();
            // transform the album year integer into a string
            String albumYearToString = Integer.toString(albumYear);
            // set the album year text on the album_year_text_view
            viewHolder.albumYear.setText(albumYearToString);
            // get the album cover image from the currentAlbum object and set this image on the album_image_view
            viewHolder.albumCover.setImageResource(currentAlbum.getAlbumResourceId());
            // Make sure the view is visible
            viewHolder.albumCover.setVisibility(View.VISIBLE);
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
        TextView albumArtist;
        TextView albumTitle;
        TextView albumYear;
        ImageView albumCover;
    }
}