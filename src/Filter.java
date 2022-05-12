import java.awt.Color;

abstract public class Filter {
    protected Picture image;

    public Filter(Picture image) {
        this.image = image;
    }

    abstract public void addFilter();

    protected Picture getPart(Picture image, int pixelSize, int x, int y) {
        return image.getSubimage(x, y, pixelSize);
    }

    protected int averageRBG(Picture image) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int x = 0; x < image.lenght(); x++) {
            for (int y = 0; y < image.height(); y++) {
                Color currentColor = new Color(image.getPixel(x, y));
                r += currentColor.getRed();
                g += currentColor.getGreen();
                b += currentColor.getBlue();
            }
        }
        r /= image.lenght() * image.height();
        g /= image.lenght() * image.height();
        b /= image.lenght() * image.height();
        
        Color averageColor = new Color(r, g, b);
        return averageColor.getRGB();
    }
}
