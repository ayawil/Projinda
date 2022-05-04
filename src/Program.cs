namespace src
{
    class Program
    {
        private Picture picture;
        //private FilterPixel pixelArt;

        static void Main(string[] args)
        {
            picture = new Picutre();
            Console.WriteLine("Write the location of the picture");
            string location = Console.ReadLine();

            picture.create(location);
            FilterPixel pixelArt = new FilterPixel(picture);
            pixelArt.AddFilter();
            picture.Export();
        }
    }
}