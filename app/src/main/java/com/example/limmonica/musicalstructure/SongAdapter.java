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
    SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Initialize the ViewHolder
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.songs_item, parent, false);
            // Setup the ViewHolder
            viewHolder = new ViewHolder();
            // Find the TextView in the songs_item.xml layout with the ID song_title_text_view.
            viewHolder.songTitle = convertView.findViewById(R.id.song_title_text_view);
            // Find the TextView in the songs_item.xml layout with the ID artist_name_text_view.
            viewHolder.songArtist = convertView.findViewById(R.id.artist_name_text_view);
            // Find the TextView in the songs_item.xml layout with the ID album_title_text_view.
            viewHolder.songAlbum = convertView.findViewById(R.id.album_title_text_view);
            // Find the ImageView in the songs_item.xml layout with the ID album_cover_image_view.
            viewHolder.songAlbumCoverImage = convertView.findViewById(R.id.album_cover_image_view);
            // Store the holder tag with the view
            convertView.setTag(viewHolder);
        } else {
            // Use the viewHolder instead of calling findViewById() on resource every time
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Assign values is the currentSong object is not null
        if (currentSong != null) {
            // Get the layout elements from the ViewHolder
            // Get the song's name from the currentSong object and set this text on the song_title_text_view
            viewHolder.songTitle.setText(currentSong.getSongName());
            // Get the artist name from the currentSong object and set this text on the artist_name_text_view
            viewHolder.songArtist.setText(currentSong.getArtistName());
            // Get the album name from the currentSong object and set this text on the album_title_text_view
            viewHolder.songAlbum.setText(currentSong.getAlbumName());
            // Get the Resource ID from the currentSong object and set this image on the album_cover_image_view
            viewHolder.songAlbumCoverImage.setImageResource(currentSong.getAlbumImageResourceId());
            // Make sure the view is visible
            viewHolder.songAlbumCoverImage.setVisibility(View.VISIBLE);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
        return convertView;
    }

    /**
     * Create a class {@link ViewHolder} to hold/cache the exact set of views that we need.
     * A {@link ViewHolder} object stores each of the component views inside the tag field of the
     * Layout, so it can immediately be accessed without the need to look them up repeatedly.
     */

    static class ViewHolder {
        TextView songTitle;
        TextView songArtist;
        TextView songAlbum;
        ImageView songAlbumCoverImage;
    }
}