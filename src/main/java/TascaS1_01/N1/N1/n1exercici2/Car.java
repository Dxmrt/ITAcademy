package TascaS1_01.N1.N1.n1exercici2;

public class Car {
    public static final String brand = "Renault";
    public static String model;
    public final int power;

    public Car(String model, int power) {
        Car.model = model;
        this.power = power;
    }

    public void setModel(String model) {
        Car.model = model; //si se quisiera crear una instancia y reutilizar el objeto
    }

    public String getModel() {
        return model;
    }


    public int getPower() {
        return power;
    }


    public static String decelerate() {
        return "The car is braking";
    }

    public static String accelerate() {
        return "The car is accelerating";
    }

    @Override
    public String toString() {
        return "This car is a " + brand + " a model " + this.getModel() + " with a power of " +
                this.getPower() + " kW";
    }
}