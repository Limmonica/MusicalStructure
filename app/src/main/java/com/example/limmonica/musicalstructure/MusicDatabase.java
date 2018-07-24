package com.example.limmonica.musicalstructure;

import java.util.ArrayList;

/**
 * {@link MusicDatabase} is a Singleton class with getInstance() methods as a source of data for the
 * music structure app
 */
public class MusicDatabase {

    /**
     * static variable of the single instance of type Singleton
     */
    private static MusicDatabase INSTANCE = null;
    /**
     * Initialization of the ArrayList of Albums
     */
    public ArrayList<Album> albums = new ArrayList<>();
    /**
     * Initialization of the ArrayList of Songs
     */
    private ArrayList<Song> songs = new ArrayList<>();
    /**
     * Initialization of the ArrayList of Artists
     */
    private ArrayList<Artist> artists = new ArrayList<>();

    /**
     * {@link}Private constructor restricted to this class
     */
    private MusicDatabase() {
        //ARTISTS
        artists.add(new Artist("Metallica", R.drawable.metallica_artist));
        artists.add(new Artist("Guns N\' Roses", R.drawable.gunsnroses_artist));
        artists.add(new Artist("Led Zeppelin", R.drawable.ledzeppelin_artist));
        artists.add(new Artist("Queen", R.drawable.queen_artist));
        artists.add(new Artist("Pink Floyd", R.drawable.pinkfloyd_artist));
        artists.add(new Artist("Scorpions", R.drawable.scorpions_artist));
        artists.add(new Artist("AC/DC", R.drawable.acdc_artist));
        artists.add(new Artist("Bon Jovi", R.drawable.bonjovi_artist));
        artists.add(new Artist("Nirvana", R.drawable.nirvana_artist));
        artists.add(new Artist("Europe", R.drawable.europe_artist));
        //ALBUMS
        albums.add(new Album("Metallica", 1991, R.drawable.metallica_metallica, artists.get(0)));
        albums.add(new Album("Appetite For Destruction", 1987, R.drawable.gunsnroses_appetitefordestruction, artists.get(1)));
        albums.add(new Album("Led Zeppelin IV", 1972, R.drawable.led_zeppelin_ledzeppeliniv, artists.get(2)));
        albums.add(new Album("A Night At The Opera", 1975, R.drawable.queen_anightattheopera, artists.get(3)));
        albums.add(new Album("The Wall", 1979, R.drawable.pinkfloyd_thewall, artists.get(4)));
        albums.add(new Album("Crazy World", 1990, R.drawable.scorpions_crazyworld, artists.get(5)));
        albums.add(new Album("Highway To Hell", 1979, R.drawable.acdc_highwaytohell, artists.get(6)));
        albums.add(new Album("Crush", 2000, R.drawable.bonjovi_crush, artists.get(7)));
        albums.add(new Album("Nevermind", 1991, R.drawable.nirvana_nevermind, artists.get(8)));
        albums.add(new Album("The Final Countdown", 1986, R.drawable.europe_thefinalcountdown, artists.get(9)));
        // SONGS
        // Metallica - Metallica
        songs.add(new Song("Enter Sandman", 334000, artists.get(0), albums.get(0)));
        songs.add(new Song("Sad But True", 324000, artists.get(0), albums.get(0)));
        songs.add(new Song("Holier Than Thou", 228000, artists.get(0), albums.get(0)));
        songs.add(new Song("The Unforgiven", 386000, artists.get(0), albums.get(0)));
        songs.add(new Song("Wherever I May Roam", 404000, artists.get(0), albums.get(0)));
        songs.add(new Song("Don\'t Tread On Me", 241000, artists.get(0), albums.get(0)));
        songs.add(new Song("Through The Never", 243000, artists.get(0), albums.get(0)));
        songs.add(new Song("Nothing Else Matters", 390000, artists.get(0), albums.get(0)));
        songs.add(new Song("Of Wolf And Man", 257000, artists.get(0), albums.get(0)));
        songs.add(new Song("The God That Failed", 309000, artists.get(0), albums.get(0)));
        songs.add(new Song("My Friend Of Misery", 408000, artists.get(0), albums.get(0)));
        songs.add(new Song("The Struggle Within", 236000, artists.get(0), albums.get(0)));
        // Guns N' Roses - Appetite For Destruction
        songs.add(new Song("Welcome To The Jungle", 271000, artists.get(1), albums.get(1)));
        songs.add(new Song("It\'s So Easy", 201000, artists.get(1), albums.get(1)));
        songs.add(new Song("Nightrain", 266000, artists.get(1), albums.get(1)));
        songs.add(new Song("Out Ta Get Me", 260000, artists.get(1), albums.get(1)));
        songs.add(new Song("Mr. Brownstone", 226000, artists.get(1), albums.get(1)));
        songs.add(new Song("Paradise City", 406000, artists.get(1), albums.get(1)));
        songs.add(new Song("My Michelle", 219000, artists.get(1), albums.get(1)));
        songs.add(new Song("Think About You", 230000, artists.get(1), albums.get(1)));
        songs.add(new Song("Sweet Child O\'Mine", 355000, artists.get(1), albums.get(1)));
        songs.add(new Song("You\'re Crazy", 196000, artists.get(1), albums.get(1)));
        songs.add(new Song("Anything Goes", 205000, artists.get(1), albums.get(1)));
        songs.add(new Song("Rocket Queen", 373000, artists.get(1), albums.get(1)));
        // Led Zeppelin - Led Zeppelin IV
        songs.add(new Song("Black Dog", 294000, artists.get(2), albums.get(2)));
        songs.add(new Song("Rock And Roll", 220000, artists.get(2), albums.get(2)));
        songs.add(new Song("The Battle Of Evermore", 351000, artists.get(2), albums.get(2)));
        songs.add(new Song("Stairway To Heaven", 482000, artists.get(2), albums.get(2)));
        songs.add(new Song("Misty Mountain Hop", 278000, artists.get(2), albums.get(2)));
        songs.add(new Song("Four Sticks", 284000, artists.get(2), albums.get(2)));
        songs.add(new Song("Going To California", 221000, artists.get(2), albums.get(2)));
        songs.add(new Song("When the Levee Breaks", 427000, artists.get(2), albums.get(2)));
        // Queen - A Night At The Opera
        songs.add(new Song("Death On Two Legs", 223000, artists.get(3), albums.get(3)));
        songs.add(new Song("Lazing On A Sunday Afternoon", 68000, artists.get(3), albums.get(3)));
        songs.add(new Song("I\'m In Love With My Car", 185000, artists.get(3), albums.get(3)));
        songs.add(new Song("You\'re My Best Friend", 170000, artists.get(3), albums.get(3)));
        songs.add(new Song("39", 210000, artists.get(3), albums.get(3)));
        songs.add(new Song("Sweet Lady", 241000, artists.get(3), albums.get(3)));
        songs.add(new Song("Seaside Rendezvous", 133000, artists.get(3), albums.get(3)));
        songs.add(new Song("The Prophet\'s Song", 501000, artists.get(3), albums.get(3)));
        songs.add(new Song("Love Of My Life", 218000, artists.get(3), albums.get(3)));
        songs.add(new Song("Good Company", 206000, artists.get(3), albums.get(3)));
        songs.add(new Song("Bohemian Rhapsody", 357000, artists.get(3), albums.get(3)));
        songs.add(new Song("God Save The Queen", 71000, artists.get(3), albums.get(3)));
        // Pink Floyd - The Wall
        songs.add(new Song("In The Flesh", 196000, artists.get(4), albums.get(4)));
        songs.add(new Song("The Thin Ice", 147000, artists.get(4), albums.get(4)));
        songs.add(new Song("Another Brick In The Wall (Part 1)", 201000, artists.get(4), albums.get(4)));
        songs.add(new Song("The Happiest Days Of Our Lives", 166000, artists.get(4), albums.get(4)));
        songs.add(new Song("Another Brick In The Wall (Part 2)", 239000, artists.get(4), albums.get(4)));
        songs.add(new Song("Mother", 332000, artists.get(4), albums.get(4)));
        songs.add(new Song("Goodbye Blue Sky", 165000, artists.get(4), albums.get(4)));
        songs.add(new Song("Empty Spaces", 130000, artists.get(4), albums.get(4)));
        songs.add(new Song("Young Lust", 205000, artists.get(4), albums.get(4)));
        songs.add(new Song("One Of My Turns", 221000, artists.get(4), albums.get(4)));
        songs.add(new Song("Don\'t Leave Me Now", 248000, artists.get(4), albums.get(4)));
        songs.add(new Song("Another Brick In The Wall (Part 3)", 78000, artists.get(4), albums.get(4)));
        songs.add(new Song("Goodbye Cruel World", 78000, artists.get(4), albums.get(4)));
        songs.add(new Song("Hey You", 280000, artists.get(4), albums.get(4)));
        songs.add(new Song("Is There Anybody Out There?", 164000, artists.get(4), albums.get(4)));
        songs.add(new Song("Nobody Home", 206000, artists.get(4), albums.get(4)));
        songs.add(new Song("Vera", 95000, artists.get(4), albums.get(4)));
        songs.add(new Song("Bring The Boys Back Home", 81000, artists.get(4), albums.get(4)));
        songs.add(new Song("Comfortably Numb", 383000, artists.get(4), albums.get(4)));
        songs.add(new Song("The Show Must Go On", 96000, artists.get(4), albums.get(4)));
        songs.add(new Song("In The Flesh", 255000, artists.get(4), albums.get(4)));
        songs.add(new Song("Run Like Hell", 260000, artists.get(4), albums.get(4)));
        songs.add(new Song("Waiting For The Worms", 244000, artists.get(4), albums.get(4)));
        songs.add(new Song("Stop", 30000, artists.get(4), albums.get(4)));
        songs.add(new Song("The Trial", 313000, artists.get(4), albums.get(4)));
        songs.add(new Song("Outside The Wall", 101000, artists.get(4), albums.get(4)));
        // Scorpions - Crazy World
        songs.add(new Song("Tease Me Please Me", 280000, artists.get(5), albums.get(5)));
        songs.add(new Song("Don\'t Believe Her", 295000, artists.get(5), albums.get(5)));
        songs.add(new Song("To Be With You In Heaven", 288000, artists.get(5), albums.get(5)));
        songs.add(new Song("Wind Of Change", 310000, artists.get(5), albums.get(5)));
        songs.add(new Song("Restless Nights", 344000, artists.get(5), albums.get(5)));
        songs.add(new Song("Lust Or Love", 262000, artists.get(5), albums.get(5)));
        songs.add(new Song("Kicks After Six", 229000, artists.get(5), albums.get(5)));
        songs.add(new Song("Hit Between The Eyes", 273000, artists.get(5), albums.get(5)));
        songs.add(new Song("Money And Fame", 306000, artists.get(5), albums.get(5)));
        songs.add(new Song("Crazy World", 308000, artists.get(5), albums.get(5)));
        songs.add(new Song("Send Me An Angel", 272000, artists.get(5), albums.get(5)));
        // AC/DC - Highway To Hell
        songs.add(new Song("Highway To Hell", 209000, artists.get(6), albums.get(6)));
        songs.add(new Song("Girls Got Rhythm", 204000, artists.get(6), albums.get(6)));
        songs.add(new Song("Walk All Over You", 310000, artists.get(6), albums.get(6)));
        songs.add(new Song("Touch Too Much", 268000, artists.get(6), albums.get(6)));
        songs.add(new Song("Beating Around The Bush", 237000, artists.get(6), albums.get(6)));
        songs.add(new Song("Shot Down In Flames", 203000, artists.get(6), albums.get(6)));
        songs.add(new Song("Get It Hot", 155000, artists.get(6), albums.get(6)));
        songs.add(new Song("If You Want Blood (You\'ve Got It)", 278000, artists.get(6), albums.get(6)));
        songs.add(new Song("Love Hungry Man", 258000, artists.get(6), albums.get(6)));
        songs.add(new Song("Night Prowler", 378000, artists.get(6), albums.get(6)));
        // Bon Jovi - Crush
        songs.add(new Song("It\'s My Life", 224000, artists.get(7), albums.get(7)));
        songs.add(new Song("Say It Isn\'t So", 213000, artists.get(7), albums.get(7)));
        songs.add(new Song("Thank You For Loving Me", 309000, artists.get(7), albums.get(7)));
        songs.add(new Song("Two Story Town", 310000, artists.get(7), albums.get(7)));
        songs.add(new Song("Next 100 Years", 379000, artists.get(7), albums.get(7)));
        songs.add(new Song("Just Older", 269000, artists.get(7), albums.get(7)));
        songs.add(new Song("Mystery Train", 314000, artists.get(7), albums.get(7)));
        songs.add(new Song("Save The World", 331000, artists.get(7), albums.get(7)));
        songs.add(new Song("Captain Crash & The Beauty Queen From Mars", 271000, artists.get(7), albums.get(7)));
        songs.add(new Song("She\'s A Mystery", 318000, artists.get(7), albums.get(7)));
        songs.add(new Song("I Got The Girl", 276000, artists.get(7), albums.get(7)));
        songs.add(new Song("One Wild Night", 258000, artists.get(7), albums.get(7)));
        songs.add(new Song("I Could Make A Living Out Of Lovin\' You", 280000, artists.get(7), albums.get(7)));
        songs.add(new Song("Neurotica", 285000, artists.get(7), albums.get(7)));
        // Nirvana - Nevermind
        songs.add(new Song("Smells Like Teen Spirit", 301000, artists.get(8), albums.get(8)));
        songs.add(new Song("In Bloom", 254000, artists.get(8), albums.get(8)));
        songs.add(new Song("Come As You Are", 219000, artists.get(8), albums.get(8)));
        songs.add(new Song("Breed", 183000, artists.get(8), albums.get(8)));
        songs.add(new Song("Lithium", 257000, artists.get(8), albums.get(8)));
        songs.add(new Song("Polly", 177000, artists.get(8), albums.get(8)));
        songs.add(new Song("Territorial Pissings", 142000, artists.get(8), albums.get(8)));
        songs.add(new Song("Drain You", 223000, artists.get(8), albums.get(8)));
        songs.add(new Song("Lounge Act", 156000, artists.get(8), albums.get(8)));
        songs.add(new Song("Stay Away", 212000, artists.get(8), albums.get(8)));
        songs.add(new Song("On A Plain", 206000, artists.get(8), albums.get(8)));
        songs.add(new Song("Something In The Way", 1235000, artists.get(8), albums.get(8)));
        // Europe - The Final Countdown
        songs.add(new Song("The Final Countdown", 312000, artists.get(9), albums.get(9)));
        songs.add(new Song("Rock The Night", 243000, artists.get(9), albums.get(9)));
        songs.add(new Song("Carrie", 270000, artists.get(9), albums.get(9)));
        songs.add(new Song("Danger On The Track", 225000, artists.get(9), albums.get(9)));
        songs.add(new Song("Ninja", 226000, artists.get(9), albums.get(9)));
        songs.add(new Song("Cherokee", 260000, artists.get(9), albums.get(9)));
        songs.add(new Song("Time Has Come", 241000, artists.get(9), albums.get(9)));
        songs.add(new Song("Heart Of Stone", 226000, artists.get(9), albums.get(9)));
        songs.add(new Song("On The Loose", 188000, artists.get(9), albums.get(9)));
        songs.add(new Song("Love Chaser", 207000, artists.get(9), albums.get(9)));
    }

    public static MusicDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MusicDatabase();
        }
        return (INSTANCE);
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
