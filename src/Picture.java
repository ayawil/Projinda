import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

public class Picture {

    private BufferedImage image;
    private String name;

    public void create(String location) {
        name = extractName(location);

        try {
            File importedPicture = new File(location);
            image = new BufferedImage(ImageIO.read(importedPicture).getWidth(), ImageIO.read(importedPicture).getHeight(), BufferedImage.TYPE_INT_RGB);
            
            image = ImageIO.read(importedPicture);
        } catch (IOException e) {
            //TODO: handle exception
        }

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

    public void create(BufferedImage newImage) {
        image = newImage;
    }

    public void export() {
        try {
            File exportedImage = new File(name + "_exported.png");
            ImageIO.write(image, "png", exportedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int height() {
        return image.getHeight();
    }

    public int lenght() {
        return image.getWidth();
    }

    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }

    public void setPixel(int x, int y, int color) {
        image.setRGB(x, y, color);
    }

    public Picture getSubimage(int x, int y, int pixelSize) {
        Picture tmp = new Picture();
        tmp.create(image.getSubimage(x, y, pixelSize, pixelSize));

        return tmp;
    }
}