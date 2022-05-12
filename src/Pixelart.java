public class Pixelart extends Filter {
    private int pixelSize;

    public Pixelart(Picture image) {
        super(image);
        pixelSize = 4;

    }

    public void addFilter() {
        for (int x = 0; x < image.lenght(); x += pixelSize) {
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
