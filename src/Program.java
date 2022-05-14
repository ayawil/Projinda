import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {

    // private static String location;
    private static Filter filter;
    private static Picture image;

    public static void main(String[] args) {
        image = new Picture();

        // System.out.println("Image processor started correctly, please ");
        if (args.length != 0) {
            switch (args[0]) {
                case "pixel":
                    filter = new Pixelart(image);
                    // location = args[1];
                    addImage(args[1]);
                    break;
                default:
                    System.out.println("Incorrect filter type");
                    return;
            }
        }
        else
            terminalInterface();
        
        filter.addFilter();
        if (image.export())
            System.out.println("Image exported correctly");
        else {
            System.out.println("Image not exported correctly");
            return;
        }
    }

    private static boolean addImage(String location) {
        if (!image.create(location)) {
            System.out.println("Incorrect path");
            return false;
        }
        else
            return true;
    }

    private static void terminalInterface() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tFilter = "";

        String[] filters = {"pixel", "grayscale"};
        System.out.println( "Welcome to the terminal interface! \n" + 
                            "Please choose a filter from the following options:");
        for (String sFilter : filters)
            System.out.println(sFilter);

        while (filter == null) {
            try {
                tFilter = reader.readLine();
                switch (tFilter) {
                    case "pixel":
                        filter = new Pixelart(image);
                        break;
                    default:
                        System.out.println("Incorrect filter type");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect filter type");
            }
        }

        System.out.println( "Now please choose a picture to apply said filter on");
        boolean imageSuccess = false;
        while (!imageSuccess) {
            try {
                imageSuccess = addImage(reader.readLine());
            } catch (Exception e) {
                System.out.println("Incorrect path");
            }
        }
    }
}
