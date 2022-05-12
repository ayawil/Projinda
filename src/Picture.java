import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {

    private BufferedImage image;

    public void create(String location) {
        // Fix intilializatiom
        try {
            File importedPicture = new File(location);
            image = new BufferedImage(ImageIO.read(importedPicture).getWidth(), ImageIO.read(importedPicture).getHeight(), BufferedImage.TYPE_INT_RGB);
            
            image = ImageIO.read(importedPicture);
        } catch (IOException e) {
            //TODO: handle exception
        }

    }

    public void create(BufferedImage newImage) {
        image = newImage;
    }

    public void export() {
        try {
            File exportedImage = new File("export.png");
            ImageIO.write(image, "png", exportedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // image.Save("export.png");
    }

    public int height() {
        return image.getHeight();
    }

    public int lenght() {
        return image.getWidth();
    }

    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }

    public void setPixel(int x, int y, int color) {
        image.setRGB(x, y, color);
    }

    public Picture getSubimage(int x, int y, int pixelSize) {
        Picture tmp = new Picture();
        tmp.create(image.getSubimage(x, y, pixelSize, pixelSize));

        return tmp;
    }
}