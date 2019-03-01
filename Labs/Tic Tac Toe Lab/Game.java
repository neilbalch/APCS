import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private JButton newGame;
    private int player1wins;
    private int player2wins;

    public Game(){
        setLayout(null);

        // Initialize state variables
        state = new GameState();
        addMouseListener(this);

        newGame = new JButton("New Game");
        newGame.setBounds(25, 25, 100, 30);
        newGame.addActionListener(this);
        add(newGame);

        player1wins = 0;
        player2wins = 0;
    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800, 600);
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
        if(state.state == GameState.State.TURN1) g.drawString("Player 1's Turn", 250, 50);
        if(state.state == GameState.State.TURN2) g.drawString("Player 2's Turn", 250, 50);

        // Display wins
        g.drawString("Player 1 Wins: " + player1wins, 500, 250);
        g.drawString((state.mode == GameState.Mode.PvP ? "Player 2 Wins: " : "Computer Wins: ") + player2wins, 500, 280);

        // If the game is over, who won?
        if(state.state == GameState.State.OVER) {
            // Who won?
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            g.setColor(Color.RED);
            if(state.checkTicTackToe() == 0) g.drawString("TIE!", 100, 500);
            else if(state.checkTicTackToe() == 1) {
                player1wins++;
                g.drawString("Player 1 wins!", 100, 500);
            } else if(state.checkTicTackToe() == 2) {
                player2wins++;
                g.drawString(state.mode == GameState.Mode.PvP ? "Player 2 wins!" : "Computer Wins!", 100, 500);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGame) {
            state = new GameState();
            state.state = GameState.State.TURN1;
            newGame.setEnabled(false);
        }

        // No matter what, must repaint
        repaint();
    }

    boolean coordsWithin(Point location, Point topLeft, Point bottomRight) {
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
            newGame.setEnabled(true);
        }

        // No matter what, must repaint
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
