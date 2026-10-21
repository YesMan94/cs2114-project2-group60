import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
    // the loaded audio, or null
    private Clip clip;
    // path of the loaded file, or null
    private String currentFile;
    // position in microseconds when pause
    private long pausedAt;

    /**
     * Creates an constructor for Audio player.
     * 
     * @param currentFile
     *            the file path
     */
    public Audio(String currentFile) {
        clip = null;
        this.currentFile = currentFile;
        pausedAt = 0;
    }


    /**
     * Plays the given file from the start. If the file cannot be played, a
     * message is printed and nothing plays.
     */
    public void play() {
        stop();
        if (currentFile == null) {
            System.out.println("No audio file given.");
            return;
        }
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(
                currentFile));
            clip = AudioSystem.getClip();
            clip.open(stream);
            pausedAt = 0;
            clip.start();
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio format (use WAV): "
                + currentFile);
        }
        catch (IOException e) {
            System.out.println("Could not read file: " + currentFile);
        }
        catch (LineUnavailableException e) {
            System.out.println("Audio device unavailable.");
        }
    }

    // Pauses the audio and remembers the position. Does nothing if nothing is
    // playing.


    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            pausedAt = clip.getMicrosecondPosition();

        }
    }
    
    
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    // Continues from where pause() left off. Does nothing if nothing is loaded
    // or the audio is already playing.


    public void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausedAt);
            clip.start();
        }
    }

    // Stops and releases the current clip, if any.


    private void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();

        }
    }


    // the two thing which says no audio is null or gives the currentFile.
    public String toString() {
        if (currentFile == null) {
            return "No audio loaded";
        }
        return "" + currentFile;
    }
}
