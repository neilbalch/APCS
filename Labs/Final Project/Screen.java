import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.BasicStroke;

public class Screen extends JPanel implements KeyListener, ActionListener {
    // State variables
    private Point currentStage;
    private Stage[][] map;
    private int opacity;
    private boolean showHelp;
    private Point playerPosition;

    // Inventory elements
    private ArrayList<Item> inventory;
    private int selectedInventoryItem;
    // Quest elements
    private String[] quests;
    private int currentQuest;
    private boolean showEndScreen;

    // Quest status vars
    // Quest 1
    private boolean npcTalkedTo;
    private boolean npcGaveItems;

    private void playSound(String url) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource(url)));
            clip.start();
            //System.out.println("playing... " + url);
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public Screen() {
        System.out.println("Hi! Why are you looking at the console output? You should be grading!");
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);

        currentStage = new Point(1, 1);
        map = new Stage[3][3];
        map[0][0] = new LandingPoint(false, true, false, true);
        map[0][1] = new LandingPoint(false, true, true, true);
        map[0][2] = new LandingPoint(false, true, true, false);
        map[1][0] = new LandingPoint(true, true, false, true);
        map[1][1] = new LandingPoint(true, true, true, true);
        map[1][2] = new Beach(true, true,true, false);
        map[2][0] = new LandingPoint(true, false, false, true);
        map[2][1] = new Beach(true, false, true, true);
        map[2][2] = new Ocean(true, false, true, false);
        opacity = 255;
        showHelp = true;
        playerPosition = new Point(400, 300);

        inventory = new ArrayList<Item>();
        selectedInventoryItem = 0;

        quests = new String[4];
        quests[0] = "Talk to an NPC and obtain a sword and shield.";
        quests[1] = "Pick up two emeralds and exchange them with the villager for boots.";
        quests[2] = "Locate a helmet and chest plate and pick it up, then defeat the Lizard King.";
        quests[3] = "END SCREEN";
        currentQuest = 0;

        // Randomly place emeralds on the map
        for(int i = 0; i < 7; i++) {
            Point stage = new Point((int)(Math.random() * 3), (int)(Math.random() * 3));
            Point location = new Point((int)(Math.random() * 600) + 200, (int)(Math.random() * 400) + 200);

            map[stage.x][stage.y].addItem(new Emerald(location));
        }

        map[1][1].addNPC(new NPC(new Point((int)(Math.random() * 400) + 200, (int)(Math.random() * 400) + 200), "Hello! I'm an NPC. I have a lot to say, and after you read this, I have some stuff to give you, traveller!", "1"));
        map[1][1].addNPCItem(0, new Emerald(new Point(0, 0)));

        map[1][1].addItem(new Helmet(new Point(400, 400)));
        map[1][1].addItem(new Sword(new Point(440, 400)));
        map[1][1].addItem(new Sheild(new Point(490, 400)));

        showEndScreen = false;
        npcTalkedTo = false;
        npcGaveItems = false;
    }

    // Sets the size of the panel
    public Dimension getPreferredSize() { return new Dimension(800, 600); }

    private void drawHelpMenu(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Calibri", Font.BOLD, 60));
        g.drawString("Help Menu:", 75, 100);
        g.setFont(new Font("Calibri", Font.BOLD, 36));
        g.drawString("\"h\": Toggle help menu (this screen)", 75, 140);
        g.drawString("\"Up Arrow\": Move player upward", 75, 180);
        g.drawString("\"Down Arrow\": Move player downward", 75, 220);
        g.drawString("\"Left Arrow\": Move player leftward", 75, 260);
        g.drawString("\"Right Arrow\": Move player rightward", 75, 300);
        g.drawString("\"Spacebar\": Interact with NPC or portal", 75, 340);
        g.drawString("\"e\": Pick up item, from NPC or the ground", 75, 380);
        g.drawString("\"Nums 1-7\": Select item in inventory", 75, 420);
    }
    private void drawPlayer(Graphics g, Point playerPosition) {
        // Draw Body
        g.setColor(Color.RED);
        int[] x_pts = {playerPosition.x - 10, playerPosition.x, playerPosition.x + 10};
        int[] y_pts = {playerPosition.y + 25, playerPosition.y, playerPosition.y + 25};
        g.fillPolygon(x_pts, y_pts, x_pts.length);

        // Draw Head
        g.setColor(new Color(203, 174, 108));
        g.fillOval(playerPosition.x - 15/2, playerPosition.y - 10, 15, 15);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the stage as a background
        map[currentStage.x][currentStage.y].drawMe(g);

        if (opacity >= 0) { // Game just started, we are fading in from black
            drawHelpMenu(g);
            g.setColor(new Color(0, 0, 0, opacity));
            g.fillRect(0, 0, 800, 600);
            opacity-= 5;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        } else {
            drawPlayer(g, playerPosition);

            if(showHelp) drawHelpMenu(g); // Show the help menu?
        }

        // Draw in inventory
        {
            g.setColor(new Color(122, 122, 122, 174));
            g.fillRect(0, 600 - 46, 43 * 7 + 3, 46);
            g.setColor(Color.BLACK);
            // Draw in vertical lines
            for (int i = 0; i < 8; i++) g.fillRect(i * 43, 600 - 46, 3, 46);
            // Draw in horizontal lines
            g.fillRect(0, 600 - 46, 43 * 7 + 3, 3);
            g.fillRect(0, 600 - 3, 43 * 7 + 3, 3);

            // Fill inventory slots with the items
            for (int i = 0; i < inventory.size(); i++)
                inventory.get(i).drawMe(g, new Point(i * 43 + 23, 600 - 23));

            // Draw in selected inventory slot
            g.setColor(new Color(180, 180, 180));
            g.fillRect(43 * selectedInventoryItem, 600 - 46, 3, 46);
            g.fillRect(43 * selectedInventoryItem + 43, 600 - 46, 3, 46);
            g.fillRect(43 * selectedInventoryItem, 600 - 46, 46, 3);
            g.fillRect(43 * selectedInventoryItem, 600 - 3, 46, 3);
        }

        // Draw in quests display
        {
            g.setColor(new Color(64, 64, 64, 177));
            g.fillRect(0, 0, 800, 40);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Cambria", Font.PLAIN, 20));
            g.drawString("Current Quest: " + quests[currentQuest], 10, 30);
        }
    }

    public void keyPressed(KeyEvent e) {
        int moveMagnitude = 10;

        // Don't accept any actions while the game is loading in
        if(opacity > 0) return;

        switch(e.getKeyCode()) {
            case 37:    // Left Arrow
                playerPosition.setLocation(playerPosition.getX() - moveMagnitude, playerPosition.getY());
                break;
            case 38:    // Up Arrow
                playerPosition.setLocation(playerPosition.getX(), playerPosition.getY() - moveMagnitude);
                break;
            case 39:    // Right Arrow
                playerPosition.setLocation(playerPosition.getX() + moveMagnitude, playerPosition.getY());
                break;
            case 40:    // Down Arrow
                playerPosition.setLocation(playerPosition.getX(), playerPosition.getY() + moveMagnitude);
                break;
            case 32:    // Spacebar
                Point portal = map[currentStage.x][currentStage.y].portalEntered(playerPosition);
                if(portal.x != 0 || portal.y != 0) { // Which direction did the player want to move?
                   if(portal.x == 1) {          // Moving down
                       currentStage.x += 1;
                       playerPosition.y = 600 - playerPosition.y; // Teleport the player to the portal where they came from.
                   } else if(portal.x == -1) {  // Moving up
                       currentStage.x -= 1;
                       playerPosition.y = 600 - playerPosition.y; // Teleport the player to the portal where they came from.
                   } else if(portal.y == 1) {   // Moving right
                       currentStage.y += 1;
                       playerPosition.x = 800 - playerPosition.x; // Teleport the player to the portal where they came from.
                   } else if(portal.y == -1) {  // Moving left
                       currentStage.y -= 1;
                       playerPosition.x = 800 - playerPosition.x; // Teleport the player to the portal where they came from.
                   }
                } else map[currentStage.x][currentStage.y].interactWithNPCs(playerPosition);
                break;
            case 69:    // E key
                Item transferToInventory = map[currentStage.x][currentStage.y].interactWithItems(playerPosition);
                if(transferToInventory != null) inventory.add(transferToInventory);
                else { // If there were no item interactions, then interact with the NPC
                    for(int i = 0; i < map[currentStage.x][currentStage.y].npcs.size(); i++) {
                        if(map[currentStage.x][currentStage.y].npcs.get(i).isInteractedWith()) {
                            Item temp = map[currentStage.x][currentStage.y].npcs.get(i).removeFirstItem();
                            if(temp != null) inventory.add(temp);
                            break;
                        }
                    }

                }
                break;
        }

        // If key pressed is 1-7...
        if(e.getKeyCode() >= 49 && e.getKeyCode() <= 55) selectedInventoryItem = e.getKeyCode() - 49;

        // If the player moved, reset any interactions with NPCs
        int key = e.getKeyCode();
        if(key >= 37 && key <= 40) {
            for(int i = 0; i < map[currentStage.x][currentStage.y].npcs.size(); i++) map[currentStage.x][currentStage.y].npcs.get(i).resetInteract();
        }

        // Check quest status
        // TODO(Neil): Fix this
        switch(currentQuest) {
            case 0: // Quest 1
                for(int i = 0; i < map[1][1].npcs.size(); i++) {
                    if(map[1][1].npcs.get(i).getName().equals("1") && map[1][1].npcs.get(i).isInteractedWith()) npcTalkedTo = true;
                    if(map[1][1].npcs.get(i).getName().equals("1") && map[1][1].npcs.get(i).noMoreItems()) npcGaveItems = true;
                }

                if(npcTalkedTo && npcGaveItems) {
                    currentQuest++;
                    System.out.println("quest 2 now");
                }
                break;
            case 1: // Quest 2
                break;
            case 2: // Quest 3
                break;
            case 3: // End Screen
                showEndScreen = true;
                break;
        }

        repaint();
    }
    public void keyTyped(KeyEvent e) { // Cheat key handled here because we don't want to repeat the keypress accidentally
        if(e.getKeyChar() == 'p' && currentQuest < quests.length - 1) currentQuest++; // Move up quests if commanded to
        else if(e.getKeyChar() == 'h') showHelp = !showHelp;

        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void actionPerformed(ActionEvent e) { /* Handle reset button presses */ }
}
