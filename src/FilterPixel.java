import java.awt.Color;

public class FilterPixel {
    private Picture image;
    private int pixelSize;

    public FilterPixel(Picture image) {
        this.image = image;
        pixelSize = 4;

    }

    public void addFilter() {
        for (int x = 0; x < image.lenght(); x += pixelSize) {
            for (int y = 0; y < image.height(); y += pixelSize) {
                Picture imagePart = getPart(image, pixelSize, pixelSize, x, y);
                int color = average(imagePart);
                for (int i = 0; i < pixelSize; i++) {
                    for (int j = 0; j < pixelSize; j++) {
                        image.setPixel(x + i, y + j, color);
                    }
                }
            }
        }
    }

    private Picture getPart(Picture image, int width, int height, int x, int y) {

        return image.getSubimage(x, y, width, height);
    }

    private int average(Picture image) {
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
        Color averageColor = new Color(r, g, b);
        return averageColor.getRGB();
    }
}
