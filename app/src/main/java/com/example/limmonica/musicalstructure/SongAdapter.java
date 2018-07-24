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
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.songs_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the songs_item.xml layout with the ID song_title_text_view.
        TextView songTextView = listItemView.findViewById(R.id.song_title_text_view);
        // Get the Songs name from the currentSong object and set this text on the Songs TextView
        assert currentSong != null;
        songTextView.setText(currentSong.getSongName());

        // Find the TextView in the songs_item.xml layout which displays the artist name.
        TextView artistTextView = listItemView.findViewById(R.id.artist_name_text_view);
        // Get the Artist name from the currentSong object and set this text on the artist TextView
        artistTextView.setText(currentSong.getArtistName());

        // Find the TextView in the songs_item.xml layout which displays the album title.
        TextView albumTextView = listItemView.findViewById(R.id.album_title_text_view);
        // Get the Album name from the currentSong object and set this text on the album TextView
        albumTextView.setText(currentSong.getAlbumName());

        // Find the ImageView in the songs_item.xml layout with the which displays the album cover
        ImageView albumCoverImageView = listItemView.findViewById(R.id.album_cover_image_view);
        // Get the Resource ID from the currentSong object and set this image on the album cover ImageView
        albumCoverImageView.setImageResource(currentSong.getAlbumImageResourceId());
        // Make sure the view is visible
        albumCoverImageView.setVisibility(View.VISIBLE);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
        return listItemView;
    }
}