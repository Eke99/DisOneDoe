import java.util.ArrayList;
import java.util.List;


public class CarApplication {
    public static void main(String[] args) {
        // Instance of this class
        CarModel carModel = new CarModel();
        CarView frame = new CarView("NeedForSpeed");


        carModel.addCar(CarFactory.createSaab95(0, 0));
        carModel.addCar(CarFactory.createVolvo240(0, 100));
        carModel.addCar(CarFactory.createScania(0, 200));

        CarController cc = new CarController(frame, carModel);

        carModel.addObserver(frame.drawPanel);

        // Start a new view and send a reference of self

        // Start the timer
        cc.getTimer().start();

    }
}
