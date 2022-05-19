public class Pixelart extends Filter {
    private int pixelSize;

    /**
     * The constructor for the pixelart filter
     * @param image the image of which to base
     *              the pixelart of
     */
    public Pixelart(Picture image) {
        super(image);
        pixelSize = 4;
    }

    /**
     * The constructor for the pixelart filter that takes in pixel size
     * @param image
     * @param pixelSize
     */
    public Pixelart(Picture image, int pixelSize) {
        super(image);
        this.pixelSize = pixelSize;
    }

    public void addFilter() {
        for (int x = 0; x < image.width(); x += pixelSize) {
            for (int y = 0; y < image.height(); y += pixelSize) {
                Picture imagePart = getPart(image, pixelSize, x, y);
                int color = averageRBG(imagePart);
                for (int i = 0; i < pixelSize; i++)
                    for (int j = 0; j < pixelSize; j++)
                        image.setPixel(x + i, y + j, color);
            }
        }
    }
}
