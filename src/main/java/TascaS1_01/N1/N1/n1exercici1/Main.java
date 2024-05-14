package TascaS1_01.N1.N1.n1exercici1;

public class Main {
    public static void main(String[] args) {
        Rope violin = new Rope("Violin", 450);
        Wind saxo = new Wind("Saxo", 320);
        Percussion drums = new Percussion("Drums", 500);

        System.out.println(violin);

        System.out.println(violin.play());
    }
}
