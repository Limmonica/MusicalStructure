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
 * {@link SongAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Song} objects.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * Create a new {@link SongAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param songs   is the list of {@link Song}s to be displayed.
     */
    SongAdapter(Context context, List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Initialize the ViewHolder
        ViewHolder holder;

        // If there is no existing view being reused
        if (convertView == null) {
            // Inflate the view
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.songs_item, parent, false);
            // Setup the ViewHolder
            holder = new ViewHolder(convertView);
            // Store the holder tag with the view
            convertView.setTag(holder);
        } else {
            // Use the holder instead of calling findViewById() on resource every time
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Assign values if the currentSong object is not null
        if (currentSong != null) {
            // Get the layout elements from the ViewHolder
            // Get the song's name from the currentSong object and set this text on
            // the song_title_text_view
            holder.songTitle.setText(currentSong.getSongName());
            // Get the artist name from the currentSong object and set this text on
            // the song_artist_name_text_view
            holder.songArtist.setText(currentSong.getArtistName());
            // Get the album name from the currentSong object and set this text on
            // the song_album_title_text_view
            holder.songAlbum.setText(currentSong.getAlbumName());
            // Get the Resource ID from the currentSong object and set this image on
            // the song_album_cover_image_view
            holder.songAlbumCoverImage.setImageResource(currentSong.getAlbumImageResourceId());
            // Make sure the view is visible
            holder.songAlbumCoverImage.setVisibility(View.VISIBLE);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return convertView;
    }

    /**
     * Create a class {@link ViewHolder} to hold/cache the exact set of views that we need.
     * A {@link ViewHolder} object stores each of the component views inside the tag field of the
     * Layout, so it can immediately be accessed without the need to look them up repeatedly.
     */

    static class ViewHolder {
        // Find and bind with the variable the TextView in the songs_item.xml layout with the ID
        // song_title_text_view.
        @BindView(R.id.song_title_text_view)
        TextView songTitle;
        // Find and bind with the variable the TextView in the songs_item.xml layout with the ID
        // song_artist_name_text_view.
        @BindView(R.id.song_artist_name_text_view)
        TextView songArtist;
        // Find and bind with the variable the TextView in the songs_item.xml layout with the ID
        // song_album_title_text_view.
        @BindView(R.id.song_album_title_text_view)
        TextView songAlbum;
        // Find and bind with the variable the ImageView in the songs_item.xml layout with the ID
        // song_album_cover_image_view.
        @BindView(R.id.song_album_cover_image_view)
        ImageView songAlbumCoverImage;

        ViewHolder(View view) {
            // Pass the view to ButterKnife to bind it
            ButterKnife.bind(this, view);
        }
    }
}