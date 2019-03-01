import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// For sound
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
// END for sound


class GameState {
    public enum State {START, TURN1, TURN2, OVER};
    public State state;

    public enum Mode {PvP, PvComp};
    public Mode mode;

    public int[][] board;

    GameState() {
        state = State.START;
        mode = Mode.PvP;
        board = new int[3][3];
    }

    // depreciated
    public void printTable() {
        for(int[] row : board) {
            for(int item : row) {
                String toPrint = "";
                if(item == 0) toPrint += "-";
                else if(item == 1) toPrint += "X";
                else if(item == 2) toPrint += "O";
                System.out.print(toPrint + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void insertXO(int x, int y) {
        if(board[x][y] == 0) {
            if(state == State.TURN1) board[x][y] = 1;
            else board[x][y] = 2;
        }

        if(state == State.TURN1) state = State.TURN2;
        else state = State.TURN1;
    }

    public boolean checkFull() {
        boolean full = true;
        for(int[] row : board) {
            for(int item : row) {
                if(item == 0) full = false;
            }
        }

        return full;
    }

    public int checkTicTackToe() {
        // Check Left-to-rights
        if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1) return 1;
        if(board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) return 2;
        if(board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1) return 1;
        if(board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2) return 2;
        if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1) return 1;
        if(board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2) return 2;
        // Check Up-and-Downs
        if(board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1) return 1;
        if(board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2) return 2;
        if(board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1) return 1;
        if(board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2) return 2;
        if(board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1) return 1;
        if(board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2) return 2;
        // Check diagonals
        if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) return 1;
        if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) return 2;
        if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) return 1;
        if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) return 2;

        return 0;
    }
}

public class Game extends JPanel implements ActionListener, MouseListener {
//    private GameState previousState;
    private GameState state;
    private JButton newPvPGame;
    private JButton newCompGame;
    private int player1wins;
    private int player2wins;
    private boolean playCompleted = false;

    public Game(){
        setLayout(null);

        // Initialize state variables
        state = new GameState();
        addMouseListener(this);

        newPvPGame = new JButton("New Game: PvP");
        newPvPGame.setBounds(25, 25, 125, 30);
        newPvPGame.addActionListener(this);
        add(newPvPGame);

        newCompGame = new JButton("New Game: vs. Computer");
        newCompGame.setBounds(160, 25, 200, 30);
        newCompGame.addActionListener(this);
        add(newCompGame);

        player1wins = 0;
        player2wins = 0;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
    }

    private void playSound(String soundFile) {
        while(playCompleted) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                //
            }
        }
        playCompleted = true;

        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource(soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        playCompleted = false;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Set the scene... literally
        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);

        // Draw Grid
        g.setColor(Color.BLACK);
        g.fillRect(200, 100, 10, 320);
        g.fillRect(310, 100, 10, 320);
        g.fillRect(100, 200, 320, 10);
        g.fillRect(100, 310, 320, 10);

        // Draw the Xes and Os
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        // x: +30, y: +65
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                if(state.board[r][c] == 1) g.drawString("X", 110 * r + 130, 110 * c + 165);
                else if(state.board[r][c] == 2) g.drawString("O", 110 * r + 130, 110 * c + 165);
                // if not 1 or 2, then its 0, and we draw nothing
            }
        }

        // Display turns
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        if(state.state == GameState.State.TURN1) g.drawString("Player 1's Turn", 400, 50);
        if(state.state == GameState.State.TURN2) g.drawString("Player 2's Turn", 400, 50);

        // Display wins
        g.drawString("Player 1 Wins: " + player1wins, 500, 250);
        g.drawString((state.mode == GameState.Mode.PvP ? "Player 2 Wins: " : "Computer Wins: ") + player2wins, 500, 280);

        // If the game is over, who won?
        if(state.state == GameState.State.OVER) {
            // Who won?
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            g.setColor(Color.RED);
            if(state.checkTicTackToe() == 0) {
                playSound("tie.wav");
                g.drawString("TIE!", 100, 500);
            } else if(state.checkTicTackToe() == 1) {
                playSound("win.wav");
                player1wins++;
                g.drawString("Player 1 wins!", 100, 500);
            } else if(state.checkTicTackToe() == 2) {
                playSound("win.wav");
                player2wins++;
                g.drawString(state.mode == GameState.Mode.PvP ? "Player 2 wins!" : "Computer Wins!", 100, 500);
            }
        }

        // Handle AI stuffs
        if(state.mode == GameState.Mode.PvComp && state.state == GameState.State.TURN2) {
            Point selection = new Point(1,1);
            // Select a random empty box
            while(state.board[selection.x][selection.y] != 0) {
                selection.x = (int)(3 * Math.random());
                selection.y = (int)(3 * Math.random());
            }
            // Take it
            state.insertXO(selection.x, selection.y);

            // Check to see if the game is over
            if(state.checkFull() || state.checkTicTackToe() != 0) {
                state.state = GameState.State.OVER;
                newPvPGame.setEnabled(true);
                newCompGame.setEnabled(true);
            }

            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newPvPGame) {
            state = new GameState();
            state.state = GameState.State.TURN1;
            newPvPGame.setEnabled(false);
            newCompGame.setEnabled(false);
        } if(e.getSource() == newCompGame) {
            state = new GameState();
            state.state = GameState.State.TURN1;
            state.mode = GameState.Mode.PvComp;
            newPvPGame.setEnabled(false);
            newCompGame.setEnabled(false);
        }

        // No matter what, must repaint
        repaint();
    }

    // Returns whether or not the provided location is within the bounding box provided
    private boolean coordsWithin(Point location, Point topLeft, Point bottomRight) {
        if(location.x > topLeft.x && location.x < bottomRight.x &&
           location.y > topLeft.y && location.y < bottomRight.y) return true;
        else return false;
    }

    public void mouseClicked(MouseEvent e) {
        if(!(state.state == GameState.State.TURN1 || state.state == GameState.State.TURN2)) return;

        if(coordsWithin(e.getPoint(), new Point(100, 100), new Point(200, 200))) {
            state.insertXO(0,0);
        } else if(coordsWithin(e.getPoint(), new Point(210, 100), new Point(310, 200))) {
            state.insertXO(1,0);
        } else if(coordsWithin(e.getPoint(), new Point(320, 100), new Point(420, 200))) {
            state.insertXO(2,0);
        } else if(coordsWithin(e.getPoint(), new Point(100, 210), new Point(200, 310))) {
            state.insertXO(0,1);
        } else if(coordsWithin(e.getPoint(), new Point(210, 210), new Point(310, 310))) {
            state.insertXO(1,1);
        } else if(coordsWithin(e.getPoint(), new Point(320, 210), new Point(420, 310))) {
            state.insertXO(2,1);
        } else if(coordsWithin(e.getPoint(), new Point(100, 320), new Point(200, 420))) {
            state.insertXO(0,2);
        } else if(coordsWithin(e.getPoint(), new Point(210, 320), new Point(310, 420))) {
            state.insertXO(1,2);
        } else if(coordsWithin(e.getPoint(), new Point(320, 320), new Point(420, 420))) {
            state.insertXO(2,2);
        }

        // Check to see if the game is over
        if(state.checkFull() || state.checkTicTackToe() != 0) {
            state.state = GameState.State.OVER;
            newPvPGame.setEnabled(true);
            newCompGame.setEnabled(true);
        }

        // No matter what, must repaint
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
