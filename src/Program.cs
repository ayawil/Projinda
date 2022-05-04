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
            string location = "Skog.jpeg";
            try
            {
                picture.create(location);
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