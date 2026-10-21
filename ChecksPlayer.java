// -------------------------------------------------------------------------
/**
 * The ChecksPlayer class is the intermediary between the Main class and all of
 * the other classes. It does the error checking on any method that Main would
 * be trying to call.
 * 
 * @author Cody Gianocaro
 * @version Oct 13, 2026
 */
public class ChecksPlayer {
    private Library library;
    private PlayQueue queue;

    // ----------------------------------------------------------
    /**
     * Create a new ChecksPlayer object.
     */
    public ChecksPlayer() {
        library = new Library();
        queue = new PlayQueue();
    }


    // ----------------------------------------------------------
    /**
     * Goes to queue.previous and plays the message/song.
     */
    public void previous() {
        if (queue.hasPrevious()) {
            queue.previous();
            play();
        }
    }


    // ----------------------------------------------------------
    /**
     * Goes to queue.previous and plays the message/song.
     */
    public void next() {
        if (queue.hasNext()) {
            queue.next();
            play();
        }
    }


    // ----------------------------------------------------------
    /**
     * Adds a new object to the queue
     * 
     * @param obj
     *            the object to be added
     */
    public void addToQueue(String obj) {
        Object temp = library.findByTitle(obj);
        if (temp != null) {
            queue.add((Song)temp);
        }
        else {
            throw new IllegalArgumentException("File does not exist");
        }
    }


    // ----------------------------------------------------------
    /**
     * Plays the current song
     */
    public void play() {
        Audio file = queue.getCurrent().getAudio();
        if (file.isPlaying()) {
            file.pause();
        }
        else {
            file.play();
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns a String representation of the current object
     * 
     * @return a String of the object currently in the queue
     */
    public String showNowPlaying() {
        return queue.getCurrent().toString();
    }


    // ----------------------------------------------------------
    /**
     * Returns a String representation of the next object
     * 
     * @return a String of the next object in the queue
     */
    public String showNextUp() {
        queue.next();
        return queue.getCurrent().toString();
    }


    // ----------------------------------------------------------
    /**
     * Returns a String representation of the queue
     * 
     * @return a String of the queue
     */
    public String showQueue() {
        return queue.toString();
    }


    // ----------------------------------------------------------
    /**
     * Getter for the queue
     * 
     * @return queue
     */
    public PlayQueue getQueue() {
        return queue;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the library
     * 
     * @return library
     */
    public Library getLibrary() {
        return library;
    }
}
