import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GameState {
//    public enum State {START, TURN1, TURN2, OVER};
//    public State state;

    public Color[][] canvas;
    public int lineWidth = 2;
    public Dimension gridSize = new Dimension(400, 400);
    public Point gridStart = new Point(50, 75);

    public Color[] palette;
    public Dimension paletteBoxSize = new Dimension(30, 30);
    public Point paletteStart = new Point(200, 10);

    GameState(int rows, int columns) {
//        state = State.START;
        canvas = new Color[rows][columns];
        palette = new Color[6];

        for(int r = 0; r < canvas.length; r++) {
            for(int c = 0; c < canvas[r].length; c++) {
                canvas[r][c] = Color.WHITE;
            }
        }

        palette[0] = Color.WHITE;
        palette[1] = Color.BLACK;
        palette[2] = Color.RED;
        palette[3] = Color.YELLOW;
        palette[4] = Color.GREEN;
        palette[5] = Color.ORANGE;
    }

    // depreciated
    public void printTable() {
        for(Color[] row : canvas) {
            for(Color item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }
}

public class Game extends JPanel implements ActionListener, MouseListener {
//    private GameState previousState;
    private GameState state;
    private JButton clearGrid;
    private int selectedColor;

    public Game(){
        setLayout(null);

        clearGrid = new JButton("Clear Grid");
        clearGrid.setBounds(25, 25, 125, 30);
        clearGrid.addActionListener(this);
        add(clearGrid);

        selectedColor = 0;

        // Initialize state variables
        state = new GameState(8, 8);
        addMouseListener(this);
    }

    // Sets the size of the panel
    public Dimension getPreferredSize() { return new Dimension(800, 600); }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Set the scene... literally
        g.setColor(Color.green);
        g.fillRect(0,0,1000,600);

        // Draw Grid
        g.setColor(Color.BLACK);

        // Draw Vertical Lines
        for(int i = 0; i < state.canvas[0].length + 1; i++) {
            g.fillRect(state.gridStart.x + i * (state.gridSize.width / state.canvas[0].length + state.lineWidth),
                    state.gridStart.y,
                    state.lineWidth,
                    state.gridSize.height  + state.lineWidth * (state.canvas.length + 1));
        }
        for(int i = 0; i < state.canvas.length + 1; i++) {
            g.fillRect(state.gridStart.x,
                    state.gridStart.y + i * (state.gridSize.height / state.canvas.length + state.lineWidth),
                    state.gridSize.width + state.lineWidth * (state.canvas[0].length + 1),
                    state.lineWidth);
        }

        // Draw the pixels
        for(int r = 0; r < state.canvas.length; r++) {
            for(int c = 0; c < state.canvas[r].length; c++) {
                g.setColor(state.canvas[r][c]);
                g.fillRect(state.gridStart.x + state.lineWidth + c * (state.gridSize.width / state.canvas[r].length + state.lineWidth),
                        state.gridStart.y + state.lineWidth + r * (state.gridSize.height / state.canvas[r].length + state.lineWidth),
                        state.gridSize.width / state.canvas[r].length,
                        state.gridSize.height / state.canvas.length);
            }
        }

        // Draw Palette Grid
        g.setColor(Color.BLACK);

        // Draw Palette Lines
        for(int i = 0; i < state.palette.length + 1; i++) {
            g.fillRect(state.paletteStart.x + i * (state.paletteBoxSize.width + state.lineWidth),
                    state.paletteStart.y,
                    state.lineWidth,
                    state.paletteBoxSize.height  + state.lineWidth);
        }
        g.fillRect(state.paletteStart.x,
                state.paletteStart.y,
                (state.paletteBoxSize.width + state.lineWidth) * state.palette.length + state.lineWidth,
                state.lineWidth);
        g.fillRect(state.paletteStart.x,
                state.paletteStart.y + (state.paletteBoxSize.height + state.lineWidth),
                (state.paletteBoxSize.width + state.lineWidth) * state.palette.length + state.lineWidth,
                state.lineWidth);

        // Draw palette items
        for(int i = 0; i < state.palette.length; i++) {
            g.setColor(state.palette[i]);
            g.fillRect(state.paletteStart.x + state.lineWidth + i * (state.paletteBoxSize.width + state.lineWidth),
                    state.paletteStart.y + state.lineWidth,
                    state.paletteBoxSize.width,
                    state.paletteBoxSize.height);
        }

        // Draw Selected Color Feature
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("X", state.paletteStart.x + selectedColor * (state.paletteBoxSize.width + state.lineWidth) + 8, state.paletteStart.y + state.paletteBoxSize.height - 5);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearGrid) {
            for(int r = 0; r < state.canvas.length; r++) {
                for (int c = 0; c < state.canvas[r].length; c++) {
                    state.canvas[r][c] = Color.WHITE;
                }
            }
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
        for(int r = 0; r < state.canvas.length; r++) {
            for(int c = 0; c < state.canvas[r].length; c++) {
                Point topLeft = new Point(state.gridStart.x + c * (state.gridSize.width / state.canvas[0].length + state.lineWidth),
                        state.gridStart.y + r * (state.gridSize.height / state.canvas[0].length + state.lineWidth));
                Point bottomRight = new Point(state.gridStart.x + (c + 1) * (state.gridSize.width / state.canvas[0].length + state.lineWidth),
                        state.gridStart.y + (r + 1) * (state.gridSize.height / state.canvas[0].length + state.lineWidth));

                if(coordsWithin(e.getPoint(), topLeft, bottomRight)) state.canvas[r][c] = state.palette[selectedColor];
            }
        }

        for(int i = 0; i < state.palette.length; i++) {
            Point topLeft = new Point(state.paletteStart.x + i * (state.paletteBoxSize.width + state.lineWidth), state.paletteStart.y);
            Point bottomRight = new Point(state.paletteStart.x + (i + 1) * (state.paletteBoxSize.width + state.lineWidth), state.paletteStart.y + state.paletteBoxSize.height);

            if(coordsWithin(e.getPoint(), topLeft, bottomRight)) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    Color selected = JColorChooser.showDialog(this, "Select a Color", state.palette[i]);
                    if (selected != null) state.palette[i] = selected;
                } else selectedColor = i;
            }
        }

        // No matter what, must repaint
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
