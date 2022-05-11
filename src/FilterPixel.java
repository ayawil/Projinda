public class FilterPixel {
    private Picture image;
    private int pixelSize;

    public FilterPixel(Picture image)
    {
        this.image = image;
        pixelSize = 4;

    }

    public void addFilter()
    {
        for (int x = 0; x < image.lenght(); x += pixelSize)
        {
            for (int y = 0; y < image.height(); y += pixelSize)
            {
                Picture imagePart = getPart(image, pixelSize, pixelSize, x, y);
                int color = average(imagePart);
                for (int i = 0; i < pixelSize; i++)
                {
                    for (int j = 0; j < pixelSize; j++)
                    {
                        image.setPixel(x + i, y + j, color);
                    }
                }

            }
        }
    }

    private Picture getPart(Picture image, int width, int height, int x, int y){

        return image;
    }

    private int average(Picture image)
    {
        return 1;
    }
}
