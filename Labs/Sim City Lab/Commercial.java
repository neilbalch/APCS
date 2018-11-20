import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class Commercial {
    private static Color building = new Color(122, 122, 122);
    private static Color windows = new Color(212, 222, 0);

    public static void drawCommercialBuilding(Graphics g, Dimension root) {
        g.setColor(building);
        g.fillRect(root.width, root.height, 75, 250);

        g.setColor(windows);
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 2; j++) {
                g.fillRect(root.width + 7 + j * 37, root.height + 15 + i * 45, 22, 22);
            }
        }
    }
}