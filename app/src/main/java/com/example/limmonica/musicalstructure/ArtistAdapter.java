package com.example.limmonica.musicalstructure;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ArtistAdapter} is an {@link ArrayAdapter} that can provide the layout for each grid item
 * based on a data source, which is a list of {@link Artist} objects.
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {

    /**
     * Create a new {@link ArtistAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param artists is the list of {@link Artist}s to be displayed.
     */
    ArtistAdapter(Context context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Initialize the viewHolder
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.artists_item, parent, false);
            // Setup the viewHolder
            viewHolder = new ViewHolder();
            // Find the TextView in the artists_item.xml layout with the ID artist_textview
            viewHolder.artistName = convertView.findViewById(R.id.artist_textview);
            // Find the ImageView in the artists_item.xml layout with the ID artist_imageview
            viewHolder.artistImage = convertView.findViewById(R.id.artist_imageview);
            // Store the holder tag with the view
            convertView.setTag(viewHolder);
        } else {
            // Use the viewHolder instead of calling findViewById() on resource every time
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Assign values if the currentArtist object is not null
        if (currentArtist != null) {
            // Get the layout elements from the ViewHolder
            // Get the Artist name from the current Artist object and set this text on the artist_textview
            viewHolder.artistName.setText(currentArtist.getArtistName());
            // Get the Resource ID from the currentArtist object and set this image on the artist_imageview
            viewHolder.artistImage.setImageResource(currentArtist.getArtistImageResourceId());
            // Make sure the image is visible
            viewHolder.artistImage.setVisibility(View.VISIBLE);
        }

        // Return the whole artists_item layout (containing 1 TextView and 1 ImageView)
        // so that it can be shown in the gridview.
        return convertView;
    }

    /**
     * Create a class {@link ViewHolder} to hold/cache the exact set of views that we need.
     * A {@link ViewHolder} object stores each of the component views inside the tag field of the
     * Layout, so it can immediately be accessed without the need to look them up repeatedly.
     */
    static class ViewHolder {
        TextView artistName;
        ImageView artistImage;
    }
}
