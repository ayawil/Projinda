using System.Drawing;
class FilterPicture
{
    private Picture image;
    private int pixelSize;
    public FilterPicture(Picture image)
    {
        this.image = image;
        pixelSize = 4;

    }

    private void addFilter()
    {
        for (int x = 0; x < image.lenght(); x += pixelSize)
        {
            for (int y = 0; y < image.height(); y += pixelSize)
            {
                List<Color> colors = new List<Color>();

                for (int i = 0; i < pixelSize; i++)
                {
                    for (int j = 0; j < pixelSize; j++)
                    {
                        colors.Add(image.GetPixel(x + i, y + j));

                    }
                }
                Color avrg = average(colors);
                for (int i = 0; i < pixelSize; i++)
                {
                    for (int j = 0; j < pixelSize; j++)
                    {
                        image.SetPixel(x + i, y + j, avrg);
                    }
                }

            }
        }
    }

    private Color average(List<Color> colors)
    {
        int g = 0;
        int b = 0;
        int r = 0;
        foreach (Color color in colors)
        {
            g += color.G;
            b += color.B;
            r += color.R;
        }
        g = g / colors.Count;
        b = b / colors.Count;
        r = r / colors.Count;
        return Color.FromArgb(g, b, r);
    }
}


