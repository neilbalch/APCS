import java.util.Scanner;
import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Scenery");
        Scanner sc = new Scanner(System.in);

        /*
        System.out.print("Day or night? ");
        String night_s = sc.next().toLowerCase();
        boolean night;
        if(night_s.equals("day")) {
            night = false;
        } else {
            night = true;
        }
        System.out.print("Clouds or None? ");
        String clouds_s = sc.next().toLowerCase();
        boolean clouds;
        if(clouds_s.equals("none")) {
            clouds = false;
        } else {
            clouds = true;
        }
        */

        //DEBUG
        boolean night = false;
        boolean clouds = true;
        //DEBUG

        Scenery scene = new Scenery(night, clouds);
        fr.add(scene);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}