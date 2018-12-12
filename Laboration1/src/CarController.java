import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController extends JFrame{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    protected CarView frame;

    // A list of cars, modify if needed
    private List<Car> cars;

    //methods:
    public CarController(CarView frame, List<Car> cars){
        this.frame = frame;
        this.cars = cars;
        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();


            }
        });

        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.getGasAmount());
            }
        });

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        frame.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        frame.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

    }

    public Timer getTimer() {
        return timer;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                intersect(car);
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car);
            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    protected void turboOff() {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOff();
            }
        }

    }

    protected void turboOn() {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOn();
            }
        }
    }

    protected void liftBed(){
        for (Car car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.extendFlak();
            }
        }
    }

    protected void lowerBed(){
        for (Car car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.retractFlak();
            }
        }
    }

    private void intersect(Car car) {
        if (car.getX() + 117 > frame.drawPanel.getPreferredSize().getWidth() || car.getX() < 0
                || car.getY() > frame.drawPanel.getPreferredSize().getHeight() || car.getY() < 0) {
            car.invertDirection();
        }
    }

    protected void start() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    protected void stop() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }



}
