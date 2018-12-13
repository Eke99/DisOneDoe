import java.util.ArrayList;
import java.util.List;


public class CarApplication {
    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        model.addSaab();
        model.addVolvo();
        model.addScania();

        CarView frame = new CarView("NeedForSpeed", model);

        CarController cc = new CarController(frame, model);

        // Start the timer
        cc.getTimer().start();

    }
}
