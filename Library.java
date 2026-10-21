// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Luke Pineda lukewpineda
// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.
/**
 * This class stores a list of all the songs available in the music player. It
 * will also allows songs to be added by searching their specific title.
 *
 * @author Luke Pineda
 * @version Oct 15, 2026
 */
public class Library {
    private static final int DEFAULT_CAPACITY = 20;
    private Song[] arrayOfSongs;
    private int numberOfSongs;

    /**
     * Creates a new library with a set capacity.
     */
    public Library() {
        arrayOfSongs = new Song[DEFAULT_CAPACITY];
        numberOfSongs = 0;
    }


    /**
     * Searches the library for the specific song title
     *
     * @param title
     *            the specific title of the song
     * @return Returns the song that matches the title, otherwise null
     */
    public Song findByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (int i = 0; i < numberOfSongs; i++) {
            if (arrayOfSongs[i].getTitle().equalsIgnoreCase(title.trim())) {
                return arrayOfSongs[i];
            }
        }
        return null;
    }


    /**
     * Adds the song to the new library.
     *
     * @param newSong
     *            new song that will be added
     * @return Returns true if the song is able to be added, otherwise will
     *         return false
     */
    public boolean addSong(Song newSong) {
        if (newSong == null) {
            return false;
        }
        if (numberOfSongs == arrayOfSongs.length) {
            Song[] newSongs = new Song[arrayOfSongs.length * 2];
            for (int i = 0; i < numberOfSongs; i++) {
                newSongs[i] = arrayOfSongs[i];
            }
            arrayOfSongs = newSongs;
        }
        arrayOfSongs[numberOfSongs] = newSong;
        numberOfSongs++;
        return true;
    }


    /**
     * Retrieves the number of songs that are currently in the library.
     *
     * @return Returns the total number of songs
     */
    public int getTotalSongs() {
        return numberOfSongs;
    }


    /**
     * Retrieves a copy of all of the songs in the library.
     *
     * @return Returns an array of the songs
     */
    public Song[] getCopyOfSongs() {
        Song[] copyOfSongs = new Song[numberOfSongs];
        for (int i = 0; i < numberOfSongs; i++) {
            copyOfSongs[i] = arrayOfSongs[i];
        }
        return copyOfSongs;
    }
}
