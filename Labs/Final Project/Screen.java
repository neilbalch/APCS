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
    private Thread bossAnimator;
    private boolean fadingToBlack;
    private int blackTransparancy;

    // Quest status vars
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

        // Set map elements
        {
            currentStage = new Point(1, 1);
            map = new Stage[3][3];
            map[0][0] = new Desert(false, true, false, true);
            map[0][1] = new Savannah(false, true, true, true);
            map[0][2] = new Forrest(false, true, true, false);
            map[1][0] = new Forrest(true, true, false, true);
            map[1][1] = new LandingPoint(true, true, true, true);
            map[1][2] = new Beach(true, true, true, false);
            map[2][0] = new LandingPoint(true, false, false, true);
            map[2][1] = new Beach(true, false, true, true);
            map[2][2] = new Ocean(true, false, true, false);
        }
        opacity = 255;
        showHelp = true;
        playerPosition = new Point(400, 300);

        inventory = new ArrayList<Item>();
        selectedInventoryItem = 0;
        fadingToBlack = true;
        blackTransparancy = 0;

        // Set up quests
        {
            quests = new String[4];
            quests[0] = "Talk to an NPC and obtain a sword and shield.";
            quests[1] = "Pick up two emeralds and exchange them with the villager for boots.";
            quests[2] = "Locate a helmet and chest plate, then defeat the Lizard King.";
            quests[3] = "END SCREEN";
            currentQuest = 0;
        }

        // Randomly place emeralds on the map
        for(int i = 0; i < 7; i++) {
            Point stage = new Point((int)(Math.random() * 3), (int)(Math.random() * 3));
            Point location = new Point((int)(Math.random() * 600) + 200, (int)(Math.random() * 400) + 200);

            map[stage.x][stage.y].addItem(new Emerald(location));
        }

        map[1][1].addNPC(new NPC(new Point((int)(Math.random() * 400) + 200, (int)(Math.random() * 400) + 100), "Hello! I'm an NPC. I have a lot to say, and after you read this, I have some stuff to give you, traveller!", "1"));
        map[1][1].addNPCItem(0, new Sword(new Point(0, 0)));
        map[1][1].addNPCItem(0, new Shield(new Point(0, 0)));

        // Randomly place the villager
        {
            Point mapLocation;
            do {
                mapLocation = new Point((int)(Math.random() * 3), (int)(Math.random() * 3));
            } while((mapLocation.x == 1 && mapLocation.y == 1) || (mapLocation.x == 0 && mapLocation.y == 0));
            Point location = new Point((int)(Math.random() * 400) + 200, (int)(Math.random() * 400) + 100);
            map[mapLocation.x][mapLocation.y].addNPC(new NPC(location, "Hi! I'm a villager! Do you want to trade? I'll do boots for two emeralds. Do you have those?", "villager"));
            for(int i = 0; i < map[mapLocation.x][mapLocation.y].npcs.size(); i++) {
                if(map[mapLocation.x][mapLocation.y].npcs.get(i).getName().equals("villager")) {
                    map[mapLocation.x][mapLocation.y].npcs.get(i).addItem(new Boots(new Point(0, 0)));
                }
            }
        }

        // Randomly place Helmet
        {
            Point mapLocation;
            do {
                mapLocation = new Point((int) (Math.random() * 3), (int) (Math.random() * 3));
            } while ((mapLocation.x == 1 && mapLocation.y == 1) || (mapLocation.x == 0 && mapLocation.y == 0));
            Point location = new Point((int) (Math.random() * 400) + 200, (int) (Math.random() * 400) + 100);
            map[mapLocation.x][mapLocation.y].addItem(new Helmet(location));
        }

        // Randomly place Chestplate
        {
            Point mapLocation;
            do {
                mapLocation = new Point((int) (Math.random() * 3), (int) (Math.random() * 3));
            } while ((mapLocation.x == 1 && mapLocation.y == 1) || (mapLocation.x == 0 && mapLocation.y == 0));
            Point location = new Point((int) (Math.random() * 400) + 200, (int) (Math.random() * 400) + 100);
            map[mapLocation.x][mapLocation.y].addItem(new Chestplate(location));
        }

        map[0][0].addNPC(new LizardKing(new Point(100, 100), "", "lizardking"));

        // Quest detection variables
        npcTalkedTo = false;
        npcGaveItems = false;

        // Animation thread
        bossAnimator = new Thread(() -> {
            int time = 0;

            while(((LizardKing)map[0][0].npcs.get(0)).isAlive()) {
                if(time <= 50 && time > 0) map[0][0].npcs.get(0).changePosition(new Dimension(3, 0));
                if(time <= 100 && time > 50) map[0][0].npcs.get(0).changePosition(new Dimension(0, 3));
                if(time <= 150 && time > 100) map[0][0].npcs.get(0).changePosition(new Dimension(-3, 0));
                if(time <= 200 && time > 150) map[0][0].npcs.get(0).changePosition(new Dimension(0, -3));
                time++;
                if(time == 200) time = 0;

                try {
                    repaint();
                    Thread.sleep(1000/30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bossAnimator.start();
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

        // End screen
        if(currentQuest == 3 && !fadingToBlack) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800 , 600);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Calibri", Font.BOLD, 60));
            g.drawString("You've Won!", 225, 300);

            return;
        }

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
        if(currentQuest != 3) {
            g.setColor(new Color(64, 64, 64, 177));
            g.fillRect(0, 0, 800, 40);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Cambria", Font.PLAIN, 20));
            g.drawString("Current Quest: " + quests[currentQuest] + " (" + (currentQuest + 1) + "/3)", 10, 30);
        }

        if(currentQuest == 3 && fadingToBlack) {
            g.setColor(new Color(0, 0, 0, blackTransparancy));
            g.fillRect(0, 0, 800, 600);

            blackTransparancy++;
            if(blackTransparancy > 255) fadingToBlack = false;
            repaint();
        }

    }

    public void keyPressed(KeyEvent e) {
        int moveMagnitude = 10;

        // Don't accept any actions while the game is loading in and ended
        if(opacity > 0 && currentQuest == 3) return;

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
                } else {
                    if(currentStage.equals(new Point(0, 0))) {
                        ((LizardKing)map[0][0].npcs.get(0)).interact(playerPosition, inventory.get(selectedInventoryItem).getName().equals("sword"));
                    } else map[currentStage.x][currentStage.y].interactWithNPCs(playerPosition);
                }
                break;
            case 69:    // E key
                Item transferToInventory = map[currentStage.x][currentStage.y].interactWithItems(playerPosition);
                if(transferToInventory != null) inventory.add(transferToInventory);
                else { // If there were no item interactions, then interact with the NPC
                    for(int i = 0; i < map[currentStage.x][currentStage.y].npcs.size(); i++) {
                        if(map[currentStage.x][currentStage.y].npcs.get(i).isInteractedWith()) {
                            Item temp = map[currentStage.x][currentStage.y].npcs.get(i).removeFirstItem(inventory);
                            if(temp != null) {
                                inventory.add(temp);
                                playSound("itemPickedUp.wav");
                            }
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
        switch(currentQuest) {
            case 0: // Quest 1
                // Check for quest completion
                for(int i = 0; i < map[1][1].npcs.size(); i++) {
                    if(map[1][1].npcs.get(i).getName().equals("1") && map[1][1].npcs.get(i).isInteractedWith()) npcTalkedTo = true;
                    if(map[1][1].npcs.get(i).getName().equals("1") && map[1][1].npcs.get(i).noMoreItems()) npcGaveItems = true;
                }

                if(npcTalkedTo && npcGaveItems) {
                    currentQuest++;
                    playSound("questCompleted.wav");
                }
                break;
            case 1: // Quest 2
                for(Item i : inventory) {
                    if(i.getName().equals("boots")) {
                        currentQuest++;
                        playSound("questCompleted.wav");
                    }
                }
                break;
            case 2: // Quest 3
                boolean containsHelmet = false;
                boolean containsChest = false;
                for(Item i : inventory) {
                    if(i.getName().equals("helmet")) containsHelmet = true;
                    if(i.getName().equals("chestplate")) containsChest = true;
                }

                // If both exist, then continue and evaluate if the Lizard King has died.
                if(containsChest && containsHelmet && ((LizardKing)map[0][0].npcs.get(0)).defeated()) currentQuest++;
                break;
            case 3: // End Screen
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
