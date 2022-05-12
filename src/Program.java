public class Program {
    public static void main(String[] args) {
        Picture image = new Picture();

        // System.out.println("Image processor started correctly, please ");

        Filter filter;
        switch (args[0]) {
            case "pixel":
                filter = new Pixelart(image);
                break;
            case "grayscale":
                filter = new Grayscale(image);
                break;
            default:
                System.out.println("Incorrect arguments");
                return;
        }

        String location = args[1];
        if (!image.create(location)) {
            System.out.println("Incorrect path");
            return;
        }
        
        filter.addFilter();
        if (image.export())
            System.out.println("Image exported correctly");
        else {
            System.out.println("Image not exported correctly");
            return;
        }
    }
}
