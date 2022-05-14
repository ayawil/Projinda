import java.awt.Color;

public class Grayscale extends Filter{

    /**
     * The constructor for the grayscale filter
     * @param image the image of to be put into grayscale
     */
    public Grayscale(Picture image) {
        super(image);
    }

    public void addFilter() {
        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                image.setPixel(x, y, getGrayscale(image.getPixel(x, y)));
            }
        }
        
    }

    private int getGrayscale(int pixel) {
        Color color = new Color(pixel);
        int averageRBG = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int r = (int) (0.3 * averageRBG);
        int g = (int) (0.59 * averageRBG);
        int b = (int) (0.11 * averageRBG);

        return new Color(r, g, b).getRGB();
    }
    
}
