class Picture
{
    private bitmap image;

    public void create(string location)
    {
        try 
        {
            image = new bitmap(location);
        }
        catch(Exception)
        {
            Console.Writeline("There was a problem saving the file.");
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
    
    
}