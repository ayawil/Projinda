using System.Drawing;
class Picture
{
    private Bitmap Image;

    public void create(string location)
    {
        try
        {
            Image = new Bitmap(location);
        }
        catch (Exception)
        {
            Console.WriteLine("There was a problem saving the file.");
        }
    }

    public void Export()
    {
        Image.Save("export.png");
    }

    public int Height()
    { return Image.Height; }
    public int Lenght()
    { return Image.Width; }

    public Color GetPixel(int x, int y)
    { return Image.GetPixel(x, y); }
    public void SetPixel(int x, int y, Color color)
    { Image.SetPixel(x, y, color); }

}