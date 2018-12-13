import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel  {

    // Just a single image,
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;
    // To keep track of a singel cars position

    private CarModel model;
    //gitest

    /*
        public void notified(IMovable car) {
            moveit(car)        }
    /*
        void moveit(IMovable c) {
            if (c.getClass() == Volvo240.class) {
                volvoPoint.setLocation(c.getX(), c.getY());
            } else if (c.getClass() == Saab95.class) {
                saabPoint.setLocation(c.getX(), c.getY());
            } else if (c.getClass() == Scania.class) {
                scaniaPoint.setLocation(c.getX(), c.getY());
            }

        }
    */
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel model) {
        this(x, y);
        this.model = model;
    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (IMovable c : model.getCars()) {
            BufferedImage image = null;
            if (c.getClass() == Saab95.class) {
                image = saabImage;
            } else if (c.getClass() == Volvo240.class) {
                image = volvoImage;
            } else if (c.getClass() == Scania.class) {
                image = scaniaImage;
            }
            g.drawImage(image, (int) c.getX(), (int) c.getY(), null);
        }
    }
}
