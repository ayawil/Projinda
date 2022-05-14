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

    @Override
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

    /**
     * Changes the pixel size of the pixelized version
     * @param args  should only be one string, is the string
     *              version of the of the requested int size
     */
    @Override
    public void changeSettings(String[] args) {
        int pS;
        
        try {
            pS = Integer.parseInt(args[0]);
            if (pS > 0 && pS < image.height() && pS < image.width())
                pixelSize = pS;
            else
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Invalid pixel size, set to default of 4");
            return;
        }        
    }
}
