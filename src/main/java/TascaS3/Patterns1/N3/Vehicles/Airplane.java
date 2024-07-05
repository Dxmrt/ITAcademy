package TascaS3.Patterns1.N3.Vehicles;

public class Airplane implements Vehicle {
    @Override
    public void start() {
        System.out.println("Airplane is starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Airplane is accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Airplane is braking.");
    }
}
