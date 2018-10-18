import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener {
    // Object containing the BG ATM image
    private BufferedImage bg;

    // Accounts array, can be as big as desired
    private Bank[] accounts = {
            new Bank("John", 100.99, 1234),
            new Bank("Jen", 1000.01, 4321),
            new Bank("Jerry", 50.50, 1111)
    };
    // Holds current unlocked account. Is -1 if all accounts are locked
    private int current_account = -1;

    // Root dimension that is the parent of all other objects' positions
    private Dimension root = new Dimension(50, 50);

    // Login/Logoff UI
    private JTextField pinInput;
    private JButton checkPinInput;
    private JButton logOut;

    // Withdraw UI
    private JTextField withdrawInput;
    private JButton withdrawBtn;
    // true if previous step had an error with the withdrawal (not enough money in account)
    private boolean withdrawError = false;

    // Deposit UI
    private JTextField depositInput;
    private JButton depositBtn;

    // Account Name Change UI
    private JTextField nameInput;
    private JButton nameButton;

    public Screen() {
        setLayout(null);

        // Import BG image.
        try {
            bg = ImageIO.read(new File("./ATM-BG.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        pinInput = new JTextField();
        pinInput.setBounds(root.width, root.width + 50, 100, 30);
        add(pinInput);

        checkPinInput = new JButton("Login");
        checkPinInput.setBounds(root.width, root.height + 80, 100, 30);
        checkPinInput.addActionListener(this);
        add(checkPinInput);

        logOut = new JButton("Log Off");
        logOut.setBounds(root.width, root.height + 120, 100, 30);
        logOut.addActionListener(this);
        add(logOut);

        withdrawInput = new JTextField();
        withdrawInput.setBounds(root.width + 120, root.height + 50, 100, 30);
        // don't add until unlocked

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(root.width + 120, root.height + 80, 100, 30);
        withdrawBtn.addActionListener(this);
        // don't add until unlocked

        depositInput = new JTextField();
        depositInput.setBounds(root.width + 240, root.height + 50, 100, 30);
        // don't add until unlocked

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(root.width + 240, root.height + 80, 100, 30);
        depositBtn.addActionListener(this);
        // don't add until unlocked

        nameInput = new JTextField();
        nameInput.setBounds(root.width + 360, root.height + 50, 150, 30);
        // don't add until unlocked

        nameButton = new JButton("Change Name");
        nameButton.setBounds(root.width + 360, root.height + 80, 150, 30);
        nameButton.addActionListener(this);
        // don't add until unlocked

        setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paint BG image onto JPanel
        double scaleFactor = 1.0;
        g.drawImage(bg, 100,0, (int)(bg.getWidth() * scaleFactor), (int)(bg.getHeight() * scaleFactor), null);

        // Persistent text, always printed with the Logon/Logoff UI
        g.drawString("Enter account PIN", root.width, root.height + 45);

        // Only show fields for monetary actions if bank is unlocked
        if(current_account != -1) {
            // Make UI visible
            add(withdrawInput);
            add(withdrawBtn);
            add(depositInput);
            add(depositBtn);
            add(nameInput);
            add(nameButton);

            // Add UI text helpers
            g.drawString("Name: " + accounts[current_account].getName(), root.width, root.height);
            g.drawString("Balance: $" + accounts[current_account].getBalance(), root.width, root.height + 20);

            g.drawString("Withdraw Money", root.width + 120, root.height + 45);
            g.drawString("Deposit Money", root.width + 240, root.height + 45);
            g.drawString("Change Name", root.width + 360, root.height + 45);

            // If there was insufficient balance last time, tell the user
            if(this.withdrawError) {
                g.drawString("Err! Insufficient balance for action", root.width + 120, root.height + 125);

                // Reset the flag status
                this.withdrawError = false;
            }
        } else {
            // Make UI invisible
            remove(withdrawInput);
            remove(withdrawBtn);
            remove(depositInput);
            remove(depositBtn);
            remove(nameInput);
            remove(nameButton);

            // Add UI Helpers
            g.drawString("Name: not logged in", root.width, root.height);
            g.drawString("Balance: not logged in", root.width, root.height + 20);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // What button was pressed?
        if(e.getSource() == checkPinInput) { // Log On
            // Get PIN From Text Field
            int pin = Integer.parseInt(pinInput.getText());

            // Check PIN against each account
            for(int i = 0; i < accounts.length; i++) {
                if (accounts[i].unlock(pin)) {
                    current_account = i;
                    break;
                }
            }
        } else if(e.getSource() == logOut) { // Log Off
            accounts[current_account].lock();
            current_account = -1;
        } else if(e.getSource() == withdrawBtn) { // Withdrawal
            double amount = Double.parseDouble(withdrawInput.getText());

            // If bank tells there isn't sufficient balance, we have an issue
            if(!accounts[current_account].withdraw(amount)) {
                this.withdrawError = true;
            }
        } else if(e.getSource() == depositBtn) { // Deposit
            double amount = Double.parseDouble(depositInput.getText());
            accounts[current_account].deposit(amount);
        } else if(e.getSource() == nameButton) { // Account name change
            String name = nameInput.getText();
            accounts[current_account].setName(name);
        }

        // Redraw the whole lot
        repaint();
    }
}