using System.Drawing;
class Picture
{
    private Bitmap? image;

    public Picture()
    {
    }

    public void Create(string location)
    {
        try
        {
            image = new Bitmap(location);
        }
        catch (Exception)
        {
            Console.WriteLine("No picture found.");
        }
    }

    public void Export()
        { image.Save("export.png"); }

    public int Height()
        { return image.Height; }
    public int Lenght()
        { return image.Width; }

    public Color GetPixel(int x, int y)
        { return image.GetPixel(x, y); }
    public void SetPixel(int x, int y, Color color)
        { image.SetPixel(x, y, color); }

}