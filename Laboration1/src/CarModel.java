import java.util.ArrayList;
import java.util.List;

public class CarModel {
    List<Observer> observers = new ArrayList<>();

    List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void addObserver(Observer obs){
        observers.add(obs);
    }

    private void notifyObservers(Car car){
        for(Observer o : observers){
            o.notified(car);
        }
    }

    public void addCar(Car car) {
        cars.add(car);
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

    protected void liftBed() {
        for (Car car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.extendFlak();
            }
        }
    }

    protected void lowerBed() {
        for (Car car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.retractFlak();
            }
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
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    protected void intersect(Car car, double width, double height) {
        if (car.getX() + 117 > width || car.getX() < 0
                || car.getY() > height || car.getY() < 0) {
            car.invertDirection();
        }
    }
    protected void moveAll(double width, double height) {
        for (Car car : cars) {
            intersect(car, width, height);
            car.move();
            notifyObservers(car);
        }
    }
}
