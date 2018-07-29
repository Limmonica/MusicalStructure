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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    ArtistAdapter(Context context, List<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Initialize the holder
        ViewHolder holder;

        // If there is no existing view being reused
        if (convertView == null) {
            // Inflate the view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.artists_item, parent, false);
            // Setup the holder
            holder = new ViewHolder(convertView);
            // Store the holder tag with the view
            convertView.setTag(holder);
        } else {
            // Otherwise use the holder instead of calling findViewById() on resource every time
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Assign values if the currentArtist object is not null
        if (currentArtist != null) {
            // Get the layout elements from the ViewHolder
            // Get the Artist name from the current Artist object and set this text on
            // the artist_name_text_view
            holder.artistName.setText(currentArtist.getArtistName());
            // Get the Resource ID from the currentArtist object and set this image on
            // the artist_image_view
            holder.artistImage.setImageResource(currentArtist.getArtistImageResourceId());
            // Make sure the image is visible
            holder.artistImage.setVisibility(View.VISIBLE);
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
        // Find and bind with the variable the TextView in the artists_item.xml layout with
        // the ID artist_name_text_view
        @BindView(R.id.artist_name_text_view)
        TextView artistName;
        // Find and bind with the variable the ImageView in the artists_item.xml layout with
        // the ID artist_image_view
        @BindView(R.id.artist_image_view)
        ImageView artistImage;

        ViewHolder(View view) {
            // Pass the view to ButterKnife to bind it
            ButterKnife.bind(this, view);
        }
    }
}
