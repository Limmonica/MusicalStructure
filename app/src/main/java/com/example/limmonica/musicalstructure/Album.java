package com.example.limmonica.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Album} represents an album of songs.
 * It contains the name of the album, the name of the artist performing the songs on the album, the
 * release year of the album and the cover image of the album.
 */

public class Album implements Parcelable {

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
    // Name of the album
    private String mAlbumName;
    // Year of the album
    private int mAlbumYear;
    // Resource ID of the cover image of the album
    private int mAlbumImageResourceId;
    // The Artist object from which we'll retrieve the name of the Artist
    private Artist mArtist;
    // The list of Songs
    private List<Song> mSongs;

    /**
     * Create a new object Album
     *
     * @param albumName            is the name of the album
     * @param albumYear            is the year of the album
     * @param albumImageResourceId is the resource ID of the cover image of the album
     * @param artist               is the object Artist
     */

    Album(String albumName, int albumYear, int albumImageResourceId, Artist artist) {
        mAlbumName = albumName;
        mAlbumYear = albumYear;
        mAlbumImageResourceId = albumImageResourceId;
        mArtist = artist;
        mSongs = new ArrayList<>();
    }

    protected Album(Parcel in) {
        mAlbumName = in.readString();
        mAlbumYear = in.readInt();
        mAlbumImageResourceId = in.readInt();
        mArtist = in.readParcelable(Artist.class.getClassLoader());
    }

    /**
     * Get the name of the album
     *
     * @return the name of the album
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Get the release year of the album
     *
     * @return the year of the album
     */
    public int getAlbumYear() {
        return mAlbumYear;
    }

    /**
     * Get the resource ID of the cover image of the album
     *
     * @return the resource ID
     */
    public int getAlbumResourceId() {
        return mAlbumImageResourceId;
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
     * Get the name of the Artist
     *
     * @return the name of the artist as String
     */
    public String getAlbumArtistName() {
        return getArtist().getArtistName();
    }

    /**
     * Get the array list of songs
     *
     * @return the list of song
     */
    public List<Song> getSongs() {
        return mSongs;
    }

    /**
     * Add the song object
     *
     * @param song is the song object
     */
    public void addSong(Song song) {
        mSongs.add(song);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mAlbumName);
        parcel.writeInt(mAlbumYear);
        parcel.writeInt(mAlbumImageResourceId);
        parcel.writeParcelable(mArtist, i);
    }
}