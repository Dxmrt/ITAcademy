package TascaS1_01.N1.n1exercici2;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Astra",130);
        System.out.println(car1);
        Car car2 = new Car("Espace",80);
        System.out.println(car2);


        System.out.println(Car.accelerate());
        System.out.println(car1.decelerate());






    }
}

