import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SlotMachine {
    private int[] nums = {0, 0, 0};
    private int bet;
    private int winnings;
    private int balance;

    private String[] sounds = {"spin.wav", "win.wav", "lose.wav"}; // spin, win, lose

    private boolean playCompleted = false;

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

            // Wait for termination of spin sound.
            if(soundFile == sounds[0]) while(clip.getMicrosecondLength() != clip.getMicrosecondPosition()) { }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        playCompleted = false;
    }

    public SlotMachine(int balance) {
        this.balance = balance;
    }

    public void drawMe(Graphics g) {
        Dimension root = new Dimension(250, 50);

        g.setColor(Color.RED);
        g.fillRoundRect(root.width, root.height, 300, 500, 10, 10);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("APCS Slot Machine!", root.width + 40, root.height + 40);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Current Bet: " + this.bet, root.width + 10, root.height + 75);
        g.drawString("Current Balance: " + this.balance, root.width + 150, root.height + 75);
        g.drawString("Current Winnings: " + this.winnings, root.width + 150, root.height + 100);

        g.setFont(new Font("Arial", Font.PLAIN, 72));
        for(int i = 0; i < nums.length; i++) {
            g.drawString(Integer.toString(nums[i]), (int)(root.width + 50 + 75 * i), root.height + 250);
        }

    }

    public void bet(int bet) {
        if(this.bet > 0) {
            // Reset the balance to before the previous bet
            this.balance += this.bet;

            this.bet = bet;
            this.balance -= bet;
        } else if (balance - bet >= 0) {
            this.bet = bet;
            this.balance -= bet;
        } else {
            return;
        }
    }

    public void play() {
        if(bet == 0) return;

        playSound(sounds[0]);
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random()*9+1);
        }

        if(nums[0] == 7 && nums[1] == 7 && nums[2] == 7) {
            winnings += bet * 100;
            balance += bet * 100;
            bet = 0;
            playSound(sounds[1]);
        } else if(nums[0] == nums[1] && nums[1] == nums[2]) {
            winnings += bet * 5;
            balance += bet * 5;
            bet = 0;
            playSound(sounds[1]);
        } else if(nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            winnings += bet * 2;
            balance += bet * 2;
            bet = 0;
            playSound(sounds[1]);
        } else {
            bet = 0;
            playSound(sounds[2]);
        }
    }
}