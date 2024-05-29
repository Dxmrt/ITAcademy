package TascaS1_01.N1.N6.N1.N6_1exercici1;

public class Main {
    public static void main(String[] args) {
        String text1 = "Hola";
        String text2 = "Adeu";
        String text3 = "Bye";

        NoGenericMethods obj = new NoGenericMethods(text1, text2, text3);

        System.out.println("Object 1: " + obj.getObject(0));
        System.out.println("Object 2: " + obj.getObject(1));
        System.out.println("Object 3: " + obj.getObject(2));
    }
}

