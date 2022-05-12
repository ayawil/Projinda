import java.awt.image.BufferedImage;

public class Picture {

    private BufferedImage Image;

    public void create(String location) {
        // Fix intilializatiom
        Image = new BufferedImage(200, 200, 0);

    }

    public void create(BufferedImage newImage) {
        Image = newImage;
    }

    public void export() {
        // Image.Save("export.png");
    }

    public int height() {
        return Image.getHeight();
    }

    public int lenght() {
        return Image.getWidth();
    }

    public int getPixel(int x, int y) {
        return Image.getRGB(x, y);
    }

    public void setPixel(int x, int y, int color) {
        Image.setRGB(x, y, color);
    }

    public Picture getSubimage(int x, int y, int pixelSize) {
        Picture tmp = new Picture();
        tmp.create(Image.getSubimage(x, y, pixelSize, pixelSize));

        return tmp;
    }
}