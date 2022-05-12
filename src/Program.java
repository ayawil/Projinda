public class Program {
    public static void main(String[] args) {
        Picture image = new Picture();

        // System.out.println("Image processor started correctly, please ");

        Filter filter;
        switch (args[0]) {
            case "pixel":
                filter = new Pixelart(image);
                break;
            default:
                System.out.println("Incorrect arguments");
                return;
        }

        String location = args[1];
        image.create(location);
        
        filter.addFilter();
        image.export();
    }
}
