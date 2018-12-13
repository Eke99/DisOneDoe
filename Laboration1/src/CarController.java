import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController extends JFrame {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    protected CarView frame;
    protected CarModel model;

    // A list of model.getCars(), modify if needed

    //methods:
    public CarController(CarView frame, CarModel model) {
        this.frame = frame;
        this.model = model;
        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.start();
            }
        });

        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stop();
            }
        });
        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(frame.getGasAmount());
            }
        });

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(frame.getGasAmount());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOn();
            }
        });

        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });

        frame.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftBed();
            }
        });

        frame.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerBed();
            }
        });
        frame.getAddVolvoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addVolvo();
            }
        });
        frame.getAddSaabButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addSaab();
            }
        });
        frame.getAddScaniaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addScania();
            }
        });
        frame.getRemoveCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeCar();
            }
        });

    }

    public Timer getTimer() {
        return timer;
    }

    /* Each step the TimerListener moves all the model.getCars() in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.moveAll(frame.drawPanel.getPreferredSize().getWidth(), frame.drawPanel.getPreferredSize().getHeight());
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }
}
