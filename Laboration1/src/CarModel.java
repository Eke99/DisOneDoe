import java.util.ArrayList;
import java.util.List;

public class CarModel {
    List<Observer> observerList= new ArrayList<>();

     List<Car> cars  = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }
}
