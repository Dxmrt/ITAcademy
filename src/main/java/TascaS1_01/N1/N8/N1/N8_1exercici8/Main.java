package TascaS1_01.N1.N8.N1.N8_1exercici8;

public class Main {
    public static void main(String[] args) {
        // Implementació del mètode reverse() mitjançant una expressió lambda
        ReverseString reverser = s -> new StringBuilder(s).reverse().toString();

        // Prova del mètode reverse() amb una cadena
        String original = "hola mon";
        String reversed = reverser.reverse(original);

        // Impressió del resultat
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
