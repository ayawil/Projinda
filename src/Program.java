public class Program {
    public static void main(String[] args) {
        Picture image = new Picture();

        // System.out.println("Image processor started correctly, please ");

        String location = "Skog.jpeg";
        image.create(location);

        Filter pixelArt = new Pixelart(image);
        pixelArt.addFilter();
        image.export();
    }
}