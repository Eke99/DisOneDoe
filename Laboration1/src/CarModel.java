import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel {
    List<Observer> observers = new ArrayList<>();

    List<IMovable> cars = new ArrayList<>();

    public List<IMovable> getCars() {
        return cars;
    }

    private static final Random ran = new Random();


    public void addObserver(Observer obs){
        observers.add(obs);
    }

    private void notifyObservers(IMovable car){
        for(Observer o : observers){
            o.notified(car);
        }
    }

    public void addCar(IMovable car) {
        if(cars.size() < 8){
         cars.add(car);}
    }

    public void addVolvo(){
        addCar(CarFactory.createVolvo240(0, (cars.size() * 75) % 620));
    }

    public void addSaab(){
        addCar(CarFactory.createSaab95(0, (cars.size() * 75) % 620));
    }

    public void addScania(){
        addCar(CarFactory.createScania(0, (cars.size() * 75) % 620));
    }

    public void removeCar(){
        if(cars.size() > 0){
            cars.remove(0);}
    }

    protected void turboOff() {
        for (IMovable car : cars) {
            if (car.getClass() == Saab95.class) {
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOff();
            }
        }
    }

    protected void turboOn() {
        for (IMovable car : cars) {
            if (car.getClass() == Saab95.class) {
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOn();
            }
        }
    }

    protected void liftBed() {
        for (IMovable car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.extendFlak();
            }
        }
    }

    protected void lowerBed() {
        for (IMovable car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.retractFlak();
            }
        }
    }

    protected void start() {
        for (IMovable car : cars) {
            car.startEngine();
        }
    }

    protected void stop() {
        for (IMovable car : cars) {
            car.stopEngine();
        }
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IMovable car : cars) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IMovable car : cars) {
            car.brake(brake);
        }
    }

    protected void intersect(IMovable car, double width, double height) {
        if (car.getX() + 117 > width || car.getX() < 0
                || car.getY() > height || car.getY() < 0) {
            car.invertDirection();
        }
    }
    protected void moveAll(double width, double height) {
        for (IMovable car : cars) {
            intersect(car, width, height);
            car.move();
            notifyObservers(car);
        }
    }
}
