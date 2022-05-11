using System.Drawing;
class Picture
{
    private Bitmap image;

    public void create(string location)
    {
        try 
        {
            image = new Bitmap(location);
        }
        catch(Exception)
        {
            Console.WriteLine("There was a problem saving the file.");
        }
    }

    public void export()
    {
        image.Save("export.png");
    }

    public int height()
        { return image.height; }
    public int lenght()
        { return image.lenght; }
    public Color getPixel(int x, int y)
        { return image.getPixel(x, y); }

}