package com.example.limmonica.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlaying extends AppCompatActivity {

    // Find and bind the image view which displays the cover image of the album with the variable
    @BindView(R.id.nowplaying_album_imageview)
    ImageView albumCoverImage;
    // Find and bind the text view which displays the song title with the variable
    @BindView(R.id.nowplaying_song_name)
    TextView songName;
    // Find and bind the text view which displays the artist name with the variable
    @BindView(R.id.nowplaying_artist_name)
    TextView artistName;
    // Find and bind the text view which displays the album title with the variable
    @BindView(R.id.nowplaying_album_name)
    TextView albumName;
    // Find and bind the text view which displays the current playing time with the variable
    @BindView(R.id.nowplaying_playing_time)
    TextView timePlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        // Bind the views using ButterKnife
        ButterKnife.bind(this);

        // Retrieve the information of the clicked item passed via intent from the songs list
        Song song = getIntent().getParcelableExtra("clickedSong");

        // Get the image resource ID from the Song object and set the cover image of the song
        albumCoverImage.setImageResource(song.getAlbumImageResourceId());
        // Get the song title from the Song object and set this text to the song text view
        songName.setText(song.getSongName());
        // Get the artist name from the Song object and set this text to the artist text view
        artistName.setText(song.getArtistName());
        // Get the album name from the Song object and set this text to the album text view
        albumName.setText(song.getAlbumName());

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