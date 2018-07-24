package com.example.limmonica.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        // Retrieve the information of the clicked item passed via intent from the songs list
        Song song = getIntent().getParcelableExtra("clickedSong");

        // Find the image view which displays the cover image of the album
        ImageView albumCoverImage = findViewById(R.id.nowplaying_album_imageview);
        // Get the image resource ID from the Song object and set the cover image of the song
        albumCoverImage.setImageResource(song.getAlbumImageResourceId());

        // Find the text view which displays the song title
        TextView songName = findViewById(R.id.nowplaying_song_name);
        // Get the song title from the Song object and set this text to the song text view
        songName.setText(song.getSongName());

        // Find the text view which displays the artist name
        TextView artistName = findViewById(R.id.nowplaying_artist_name);
        // Get the artist name from the Song object and set this text to the artist text view
        artistName.setText(song.getArtistName());

        // Find the text view which displays the album title
        TextView albumName = findViewById(R.id.nowplaying_album_name);
        // Get the album name from the Song object and set this text to the album text view
        albumName.setText(song.getAlbumName());

        // Find the text view which displays the current playing time
        TextView timePlaying = findViewById(R.id.nowplaying_playing_time);
        // Initialise the current time of the playing song
        double getCurrentTimeSong = 0;
        // Display the current time of the playing song in minutes and seconds
        timePlaying.setText(String.format(getString(R.string.time_playing_update),
                TimeUnit.MILLISECONDS.toMinutes((long) getCurrentTimeSong),
                TimeUnit.MILLISECONDS.toSeconds((long) getCurrentTimeSong) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) getCurrentTimeSong)))
        );

        // Find the text view which displays the total time of the playing song
        TextView totalTimeSong = findViewById(R.id.nowplaying_total_time);
        // Get the total duration of the song from the Song object
        final int totalDurationSong = song.getSongDuration();
        // Set the text view of the total time from milliseconds to minutes and seconds
        totalTimeSong.setText(String.format(getString(R.string.song_name_playing),
                TimeUnit.MILLISECONDS.toMinutes((long) totalDurationSong),
                TimeUnit.MILLISECONDS.toSeconds((long) totalDurationSong) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                totalDurationSong))
        ));
    }
}
