import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class IconDisplay {

    public static void drawPicture(String fileName, int px, int py){
        try {
            BufferedImage image = ImageIO.read(GUI.class.getResourceAsStream(fileName));
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    GUI.setPixel(px + x, py + y, image.getRGB(x, y) == -1);
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Grid (String Grid) {
        JFrame frame = new JFrame();
        frame.setSize(12, 12);
        frame.setLayout(new GridLayout(2, 6, 8, 3));
    }
}
