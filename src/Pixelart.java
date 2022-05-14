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
     * The constructor for the pixelart filter
     * with a custom pixel size
     * @param image the image of which to base
     *              the pixelart of
     * @param pS the requested pixel size
     */
    public Pixelart(Picture image, int pS) {
        super(image);
        if (pS > 0 && pS < image.height() && pS < image.width())
            pixelSize = pS;
        else {
            System.out.println("Invalid pixel size, set to default of 4");
            pixelSize = 4;
        }
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
