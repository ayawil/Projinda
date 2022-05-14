import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {

    private static String location;
    private static Filter filter;
    private static Picture image;

    public static void main(String[] args) {
        image = new Picture();

        // System.out.println("Image processor started correctly, please ");

        switch (args[0]) {
            case "pixel":
                filter = new Pixelart(image);
                location = args[1];
                break;
            default:
                terminalInterface();
                break;
        }
        addImage();
        
        filter.addFilter();
        if (image.export())
            System.out.println("Image exported correctly");
        else {
            System.out.println("Image not exported correctly");
            return;
        }
    }

    private static void addImage() {
        if (!image.create(location)) {
            System.out.println("Incorrect path");
            return;
        }
    }
    private static void oneLineTerminal(String tLocation, String tFilter) {

    }

    private static void terminalInterface() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tFilter = "";
        location = "";

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
        while (location == "") {
            try {
                location = reader.readLine();
            } catch (Exception e) {
                System.out.println("Incorrect path");
            }
        }
    }
}
