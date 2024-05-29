package TascaS1_01.N1.N6.N1.N6_1exercici2;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Jose", "Gutierrez", 40);
        String text = "Hola";
        int number = 123;

        GenericMethods.printArgs(persona, text, number);
        GenericMethods.printArgs(text, number, persona);
    }
}
