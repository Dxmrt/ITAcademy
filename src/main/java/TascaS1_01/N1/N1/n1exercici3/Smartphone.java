package TascaS1_01.N1.N1.n1exercici3;

public class Smartphone extends Telephone implements Camera, Watch {
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void pic() {
        System.out.println("Taking a photo");
    }

    @Override
    public void alarm() {
        System.out.println("Activating the alarm");
    }
}
