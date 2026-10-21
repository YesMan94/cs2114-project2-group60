public class Song {
    private final String title;
    private final String artist;
    private final Audio audio;

    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     * 
     * @param title
     * @param artist
     * @param filePath
     */
// Constructor for song with all parameters like title, artist, genre, and the
// filepath.
    public Song(String title, String artist, String filePath) {
        if (title == null || artist == null || filePath == null) {
            throw new IllegalArgumentException("Song fields cannot be null");
        }
        this.title = title;
        this.artist = artist;
        audio = new Audio(filePath);
    }


    /**
     * gets the title
     * 
     * @return title name
     */

    public String getTitle() {
        return title;
    }


    /**
     * gets the Audio object
     * 
     * @return Audio object
     */

    public Audio getAudio() {
        return audio;
    }


    /**
     * Gets the artist.
     * 
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Two songs are equal if they have the same title, artist, genre, and
     * file path.
     * 
     * @param other
     *            the object to compare with
     * @return true if other is an equal Song
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Song song = (Song)other;
        return title.equals(song.title) && artist.equals(song.artist)
            && audio.equals(song.audio);
    }


    /**
     * Returns a readable form of the song, e.g. "Title - Artist".
     *
     * @return a string representation of this song
     */
    @Override
    public String toString() {
        return title + " - " + artist;
    }
}
