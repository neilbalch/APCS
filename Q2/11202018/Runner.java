/*
public class Runner {
    public static void main(String[] args) {
        ArrayTest at = new ArrayTest(5);
        at.print();
        System.out.println(at.getProduct());
    }
}
*/

import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Keyboard Demo");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create panel and add it to the frame
        Screen sc = new Screen();

        frame.add(sc);
        frame.pack();
        frame.setVisible(true);

    }
}