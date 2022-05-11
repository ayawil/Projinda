public class Program {
    public static void main(String[] args) {
        Picture image = new Picture();
        String location = "Skog.jpeg";
        image.create(location);

        FilterPixel pixelArt = new FilterPixel(image);
        pixelArt.addFilter();
        image.export();
    }
}