package com.example.limmonica.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Song} represents a song.
 * It contains the name of the song, the name of the artist performing the song, the name of the
 * album that the song belongs to, the cover image of the album and the duration of the song.
 */

public class Song implements Parcelable {

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
    // Name of the song
    private String mSongName;
    // Duration of the song
    private int mSongDuration;
    // Artist object from which we'll retrieve the name of the artist performing the song
    private Artist mArtist;
    // Album object from which we'll retrieve the name of the Album the song belongs to
    private Album mAlbum;

    /**
     * Create a new Song object.
     *
     * @param songName     is the is the name of the song
     * @param songDuration is the duration of the song
     * @param artist       is the object Artist
     * @param album        is the object Album
     */
    Song(String songName, int songDuration, Artist artist, Album album) {
        mSongName = songName;
        mSongDuration = songDuration;
        mArtist = artist;
        mAlbum = album;
        album.addSong(this);
    }

    private Song(Parcel in) {
        mSongName = in.readString();
        mSongDuration = in.readInt();
        mArtist = in.readParcelable(Artist.class.getClassLoader());
        mAlbum = in.readParcelable(Album.class.getClassLoader());
    }

    /**
     * Get the name of the song
     *
     * @return the name of the song
     */
    String getSongName() {
        return mSongName;
    }

    /**
     * Get the duration of the song
     *
     * @return the duration of the song
     */
    int getSongDuration() {
        return mSongDuration;
    }

    /**
     * Get the object Artist
     *
     * @return the object Artist
     */
    private Artist getArtist() {
        return mArtist;
    }

    /**
     * Get the name of the artist from the Artists object
     *
     * @return the name of the artist as string
     */
    String getArtistName() {
        return getArtist().getArtistName();
    }

    /**
     * Get the object Album
     *
     * @return the object Album
     */
    private Album getAlbum() {
        return mAlbum;
    }

    /**
     * Get the name of the album from the Album object
     *
     * @return the name of the album as string
     */
    String getAlbumName() {
        return getAlbum().getAlbumName();
    }

    /**
     * Get the Resource ID of the cover image of the album from the Album object
     *
     * @return the resource ID of the image as int
     */
    int getAlbumImageResourceId() {
        return getAlbum().getAlbumResourceId();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSongName);
        parcel.writeInt(mSongDuration);
        parcel.writeParcelable(mArtist, i);
        parcel.writeParcelable(mAlbum, i);
    }
}
