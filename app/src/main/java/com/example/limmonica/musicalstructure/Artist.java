package com.example.limmonica.musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Artist} represents an artist.
 * It contains the name of the artist performing the song and the image of the artist.
 */
public class Artist implements Parcelable {

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
    // Name of the artist
    private String mArtistName;
    // Resource ID of the image of the artist
    private int mArtistImageResourceId;

    /**
     * Create a new Artist object
     *
     * @param artistName       is the name of the artist
     * @param artistResourceId is the resource ID of the image of the artist
     */
    Artist(String artistName, int artistResourceId) {
        mArtistName = artistName;
        mArtistImageResourceId = artistResourceId;
    }

    private Artist(Parcel in) {
        mArtistName = in.readString();
        mArtistImageResourceId = in.readInt();
    }

    /**
     * Get the name of the artist
     *
     * @return the artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the resource ID of the image of the artist
     *
     * @return the resource ID
     */
    public int getArtistImageResourceId() {
        return mArtistImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mArtistName);
        parcel.writeInt(mArtistImageResourceId);
    }
}

