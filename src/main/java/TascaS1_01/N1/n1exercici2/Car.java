package TascaS1_01.N1.n1exercici2;

public class Car {
    public static final String brand = "Renault";
    public static String model;
    public final int power;

    public Car (String model, int power){
        this.model = model;
        this.power = power;
    }


    public static String decelerate(){
        return "The car is braking";
    }
    public static String accelerate(){
        return "The car is accelerating";
    }

    @Override
    public String toString(){
        return "This car is a  " + this.brand + " a model " + this.model + " with a power of " +
                this.power + " kW";
    }
}
