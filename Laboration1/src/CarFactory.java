import java.awt.*;

public class CarFactory {
    public static Volvo240 createVolvo240( double x, double y){
        Volvo240 volvo = new Volvo240(x, y);
        return volvo;
    }
    public static Saab95 createSaab95(double x, double y){
        Saab95 saab = new Saab95(x, y);
        return saab;
    }
    public static Scania createScania(double x, double y){
        Scania scania = new Scania(x, y);
        return scania;
        //Hej
    }

}
