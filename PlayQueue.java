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
 * This class uses different operations to manipulate the LinkedChain<T>. This
 * is class can also handle methods specific uses of a LinkedChain<T>.
 *
 * @author Luke Pineda
 * @version Oct 15, 2026
 */
public class PlayQueue {
    private LinkedChain<Object> queue;
    private int index;

    /**
     * Creates an empty play queue.
     */
    public PlayQueue() {
        queue = new LinkedChain<>();
        index = -1;
    }


    /**
     * Adds a new song
     *
     * @param newSong
     *            the new song that is being added
     */
    public void add(Song newSong) {
        if (newSong == null) {
            throw new IllegalArgumentException("New song cannot be added.");
        }
        queue.addToEnd(newSong);
    }


    /**
     * Travels to the next song that is queued up.
     *
     * @return the next song or null if unavailable
     */
    public Song next() {
        if (!hasNext()) {
            return null;
        }
        index++;
        return (Song)queue.get(index);
    }


    /**
     * Verifies if there is another song that is next.
     *
     * @return Returns true if there is another song next, otherwise false
     */
    public boolean hasNext() {
        return index < queue.size() - 1;
    }
    
    
    public boolean hasPrevious() {
        return index > 0;
    }


    /**
     * Moves to the previous song in the queue.
     *
     * @return the previous song or null if unavailable
     */
    public Song previous() {
        if (index == 0 || queue.get(index) == null || queue.get(index - 1) == null) {
            return null;
        }
        index--;
        return (Song)queue.get(index);
    }


    /**
     * Returns the size of the queue based on the number of songs.
     *
     * @return the number of songs
     */
    public int size() {
        return queue.size();
    }


    /**
     * Returns the song currently selected in the queue.
     *
     * @return the current song or null if empty
     */
    public Song getCurrent() {
        if(index >= queue.size()) {
            return null;
        }
        return (Song)queue.get(index);
    }
}
