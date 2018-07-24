package com.example.limmonica.musicalstructure;

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
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.artists_item, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextView in the artists_item.xml layout with the ID artist_textview.
        TextView artistNameTextView = listItemView.findViewById(R.id.artist_textview);
        // Get the Artist name from the current Artist object and set this text on the artist_textview
        assert currentArtist != null;
        artistNameTextView.setText(currentArtist.getArtistName());

        // Find the ImageView in the artists_item.xml layout with the ID artist_imageview.
        ImageView artistImageView = listItemView.findViewById(R.id.artist_imageview);
        // Get the Resource ID from the currentArtist object and set this image on the artist_imageview
        artistImageView.setImageResource(currentArtist.getArtistImageResourceId());
        // Make sure the image is visible
        artistImageView.setVisibility(View.VISIBLE);

        // Return the whole artists_item layout (containing 1 TextView and 1 ImageView)
        // so that it can be shown in the gridview.
        return listItemView;
    }
}
