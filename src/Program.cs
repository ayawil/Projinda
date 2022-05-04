using System.Reflection;

namespace src
{
    class Program
    {
        //private Picture picture;
        //private FilterPixel pixelArt;

        static void Main(string[] args)
        {
            Picture picture = new Picture();
            //while(true){
            //Console.WriteLine("Write the location of the picture");
            //string location = Console.ReadLine();
            var path = Path.Combine(Directory.GetCurrentDirectory(), "Skog.jpeg");
            string location = path;
            try
            {
                picture.Create(@location);
            }
            catch (Exception)
            {
                Console.WriteLine("Wrong path.");
            }
            //}
            FilterPixel pixelArt = new FilterPixel(picture);
            pixelArt.AddFilter();
            picture.Export();
        }
    }
}