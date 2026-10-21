import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// -------------------------------------------------------------------------
/**
 * The Main class is what the user interacts with. All of the buttons and
 * screens come from here.
 * 
 * @author Cody Gianocaro
 * @version Oct 13, 2026
 */
public class Main {
    private static ChecksPlayer check;

    // ----------------------------------------------------------
    /**
     * Create a new Main object.
     */
    public Main() {
        check = new ChecksPlayer();
        check.getLibrary().addSong(new Song("Pink Pony Club", "Chappell Roan",
            "PinkPonyClub.wav"));
        check.getLibrary().addSong(new Song("Party in the USA", "Miley Cyrus",
            "PartyInTheUSA.wav"));
        check.getLibrary().addSong(new Song("Through the Fire and the Flames",
            "Dragonforce", "TTFATF.wav"));
        check.getLibrary().addSong(new Song("Faint", "Linkin Park",
            "Faint.wav"));
        check.getLibrary().addSong(new Song("Fell in Love with a Girl",
            "The White Stripes", "FellInLove.wav"));
    }


    // ----------------------------------------------------------
    /**
     * The method that runs the program.
     * 
     * @param args
     *            not used
     */
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Main body = new Main();
        JFrame frame = new JFrame("Java Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        JButton playButton = new JButton("Play");
        JButton addButton = new JButton("Add to queue");
        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check.getQueue().getCurrent() != null) {
                    check.play();
                    System.out.println(check.showNowPlaying());
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Song[] songs = check.getLibrary().getCopyOfSongs();
                Object str = JOptionPane.showInputDialog(frame,
                    "What song would you like to add?", "Song Selection",
                    JOptionPane.QUESTION_MESSAGE, null, songs, songs[0]);
                if (str == null) {
                    JOptionPane.showMessageDialog(frame, "No song selected");
                    return;
                }
                JOptionPane.showMessageDialog(frame, str);
                Song music = (Song)str;
                try {
                    check.addToQueue(music.getTitle());
                    // playButton.setEnabled(true);
                }
                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Bad input given");
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check.getQueue().hasNext()) {
                    check.next();
                    System.out.println(check.showNowPlaying());
                }
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check.getQueue().hasPrevious()) {
                    check.previous();
                    System.out.println(check.showNowPlaying());
                }
            }
        });
        frame.add(playButton);
        // playButton.setEnabled(false);
        frame.add(nextButton);
        // nextButton.setEnabled(false);
        frame.add(previousButton);
        // previousButton.setEnabled(false);
        frame.add(addButton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "Welcome to the program!");
    }
}
