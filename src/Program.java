import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Guard;

public class Program {
    private static Filter filter;
    private static Picture image;

    public static void main(String[] args) {
        image = new Picture();
        if (args.length != 0) {
            if (args[0] == "terminal")
                terminalInterface();
            if (!checkFilterType(args[0]) || !addImage(args[1]))
                return;
        } else {
            GUI gui = new GUI(image);
        }
        filter.addFilter();
        if (image.export())
            System.out.println("Image exported correctly");
        else {
            System.out.println("Image not exported correctly");
            return;
        }
    }

    /**
     * Check if the requested filter string is represented
     * by a valid filter and then sets said filter as
     * the current one
     * 
     * @param filterString the string of the chosen filter
     * @return true if it is valid, false if otherwise
     */
    private static boolean checkFilterType(String filterString) {
        switch (filterString) {
            case "pixel":
                filter = new Pixelart(image);
                break;
            case "grayscale":
                filter = new Grayscale(image);
                break;
            default:
                System.out.println("Incorrect filter type");
                return false;
        }
        return true;
    }

    /**
     * Adds an actual image to the image which is to be handled by the program
     * 
     * @param location the path of the image of which to the added
     * @return true if the image was added correctly
     */
    private static boolean addImage(String location) {
        if (!image.create(location)) {
            System.out.println("Incorrect path");
            return false;
        } else
            return true;
    }

    /**
     * The optional terminal interface
     */
    private static void terminalInterface() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] filters = { "pixel", "grayscale" };
        System.out.println("Welcome to the terminal interface! \n" +
                "Please choose a filter from the following options:");
        for (String sFilter : filters)
            System.out.println(sFilter);

        while (filter == null) {
            try {
                checkFilterType(reader.readLine());
            } catch (Exception e) {
                System.out.println("Incorrect filter type");
            }
        }

        System.out.println("Now please choose a picture to apply said filter on");
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
