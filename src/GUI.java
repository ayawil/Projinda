import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private Picture image;
    private String location;
    private Filter filter;
    private int pixelSize;

    private JFrame f;
    private JPanel p1;
    private JPanel p2;
    private JTextField locationTextField;
    private JButton submit;
    private JSlider pixelSizeSlider;
    private JButton pixelate;
    private JButton greyscale;
    private JButton reset;
    private JButton save;
    private JLabel imageIcon;

    public GUI(Picture image) {
        this.image = image;
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Photo editor");
        f.setBounds(300, 90, 900, 600);
        f.setResizable(false);
        f.setLayout(null);

        addPanels();
        addTextFeild();
        addButtons();

        f.setVisible(true);
    }

    private void addPanels() {
        p1 = new JPanel();
        p2 = new JPanel();

        f.add(p1);
        f.add(p2);
        p1.setBounds(0, 0, 200, 600);
        p2.setBounds(200, 0, 700, 600);
        p1.setLayout(null);
        p2.setLayout(null);
        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.DARK_GRAY);
    }

    private void addTextFeild() {
        locationTextField = new JTextField();
        locationTextField.setBounds(10, 40, 100, 30);
        submit = new JButton("Submit");
        submit.setBounds(110, 40, 80, 30);
        submit.addActionListener(this);
        p1.add(locationTextField);
        p1.add(submit);
    }

    private void addButtons() {
        pixelSizeSlider = new JSlider(1, 5, 2);
        pixelSizeSlider.setBounds(15, 70, 170, 40);
        p1.add(pixelSizeSlider);

        pixelate = new JButton("Pixelate");
        pixelate.addActionListener(this);
        pixelate.setBounds(40, 120, 120, 30);
        p1.add(pixelate);

        greyscale = new JButton("Greyscale");
        greyscale.addActionListener(this);
        greyscale.setBounds(40, 170, 120, 30);
        p1.add(greyscale);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setBounds(40, 450, 120, 30);
        p1.add(reset);

        save = new JButton("Save");
        save.setBounds(60, 500, 80, 30);
        save.addActionListener(this);
        p1.add(save);
    }

    private void displayImage(ImageIcon icon) {
        imageIcon = new JLabel();
        imageIcon.setIcon(icon);
        imageIcon.setBounds(10, 0, 680, 580);
        p2.add(imageIcon);
        f.revalidate();
        f.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            location = locationTextField.getText();
            if (!image.create(location)) {
                System.out.println("Incorrect path");
            } else {
                ImageIcon icon = new ImageIcon(location);
                displayImage(icon);
            }
        } else if (e.getSource() == pixelate) {
            pixelSize = pixelSizeSlider.getValue();
            filter = new Pixelart(image, pixelSize);
            filter.addFilter();
            ImageIcon icon = new ImageIcon(image.getImage());
            p2.remove(imageIcon);
            displayImage(icon);
        } else if (e.getSource() == greyscale) {
            filter = new Grayscale(image);
            filter.addFilter();
            ImageIcon icon = new ImageIcon(image.getImage());
            p2.remove(imageIcon);
            displayImage(icon);
        } else if (e.getSource() == reset) {
            image.create(location);
            ImageIcon icon = new ImageIcon(image.getImage());
            p2.remove(imageIcon);
            displayImage(icon);
        } else if (e.getSource() == save) {
            if (image.export())
                System.out.println("Image exported correctly");
            else {
                System.out.println("Image not exported correctly");
            }
        }
    }
}
