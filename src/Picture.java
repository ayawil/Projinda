import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

public class Picture {

    private BufferedImage image;
    private String name;

    /**
     * Adds an image to the the Picture from a file path
     * @param location the path to the picture
     */
    public boolean create(String location) {
        name = extractName(location);

        try {
            File importedPicture = new File(location);
            image = new BufferedImage(ImageIO.read(importedPicture).getWidth(), 
            ImageIO.read(importedPicture).getHeight(), BufferedImage.TYPE_INT_RGB);

            image = ImageIO.read(importedPicture);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Adds an image to the the Picture from a BufferedImage
     * @param newImage the BufferedImage
     */
    public boolean create(BufferedImage newImage) {
        image = newImage;
        return true;
    }

    private String extractName(String location) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("\\w+\\.");
        Matcher matcher = pattern.matcher(location);
        if (matcher.find()) {
            sb.append(matcher.group(0));
            sb.deleteCharAt(sb.length() - 1);
        }
        else
            sb.append(location.hashCode());

        return sb.toString();
    }

    /**
     * Converts the Picture to a png and exports it
     */
    public boolean export() {
        try {
            File exportedImage = new File("../Exports/" + name + "_exported.png");
            ImageIO.write(image, "png", exportedImage);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets the height of the Picture
     * @return the height
     */
    public int height() {
        return image.getHeight();
    }

    /**
     * Gets the width of the Picture
     * @return the width
     */
    public int width() {
        return image.getWidth();
    }

    /**
     * Gets the RGB value of a pixel at a certain x, y location
     * @param x the location of the pixel on the x-axis
     * @param y the location of the pixel on the y-axis
     * @return the RBG value as an integer
     */
    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }
    /**
     * Gets the bufferedimage 
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Sets the RGB value of a pixel at a certain x, y location
     * @param x the location of the pixel on the x-axis
     * @param y the location of the pixel on the y-axis
     * @param color the color the pixel is to be set as
     * @return the RBG value as an integer
     */
    public void setPixel(int x, int y, int color) {
        image.setRGB(x, y, color);
    }

    /**
     * Creates a Picture from a part of the Picture, as a sub-picture
     * @param x the position of the square on the x-axis
     * @param y the position of the square on the y-axis
     * @param pixelSize the width of square of which to 
     *                  get from the image
     * @return the sub-picture
     */
    public Picture getSubimage(int x, int y, int pixelSize) {
        Picture tmp = new Picture();
        tmp.create(image.getSubimage(x, y, pixelSize, pixelSize));

        return tmp;
    }
}