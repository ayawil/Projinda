import java.awt.Color;

abstract public class Filter {
    protected Picture image;

    /**
     * Constructor for the abstract Filter class
     * @param image the image of which to modify
     */
    public Filter(Picture image) {
        this.image = image;
    }

    /**
     * An abstract method for applying the filter
     * to the image.
     */
    abstract public void addFilter();

    /**
     * A protected method for getting a part of an image
     * @param image the image of which to get part of
     * @param pixelSize the width of square of which to 
     *                  get from the image
     * @param x the position of the square on the x-axis
     * @param y the position of the square on the y-axis
     * @return a Picture of the part of the big image
     */
    protected Picture getPart(Picture image, int pixelSize, int x, int y) {
        return image.getSubimage(x, y, pixelSize);
    }

    /**
     * A protected method for calculating the average
     * RBG value of a Picture.
     * @param image the Picture of which to calculate
     *              the average RBG-value of
     * @return the average RBG value
     */
    protected int averageRBG(Picture image) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int x = 0; x < image.width(); x++) {
            for (int y = 0; y < image.height(); y++) {
                Color currentColor = new Color(image.getPixel(x, y));
                r += currentColor.getRed();
                g += currentColor.getGreen();
                b += currentColor.getBlue();
            }
        }
        r /= image.width() * image.height();
        g /= image.width() * image.height();
        b /= image.width() * image.height();
        
        Color averageColor = new Color(r, g, b);
        return averageColor.getRGB();
    }
}
