import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class IconDisplay {

    public static void drawPicture(String fileName, int px, int py) {
        if (GUI.class.getResourceAsStream(fileName) != null) {
            try {
                BufferedImage image = ImageIO.read(GUI.class.getResourceAsStream(fileName));
                for (int x = 0; x < image.getWidth(); x++) {
                    for (int y = 0; y < image.getHeight(); y++) {
                        GUI.setPixel(px + x, py + y, image.getRGB(x, y) == -1);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void drawArray(ArrayList<String> icons, int px, int py) {
        for (int i = 0; i < icons.size(); i++) {
            int x = px + i * (GUI.WIDTH / icons.size()) + ((GUI.WIDTH / icons.size()) - 12) / 2;
            int y = py;
            drawPicture(icons.get(i), x, y);
        }
    }
}



