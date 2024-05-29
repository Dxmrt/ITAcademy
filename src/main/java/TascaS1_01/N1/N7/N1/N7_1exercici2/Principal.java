package TascaS1_01.N1.N7.N1.N7_1exercici2;

@SuppressWarnings("deprecation")
public class Principal {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        TreballadorPresencial treballador = new TreballadorPresencial("Joan", "Perez", 20.0);

        // Invocant deprecated methods
        treballador.calcularSouAntic(23);
        double souAntic = treballador.calcularSouAntic(40);
        System.out.println("Sou antic per 40 hores: " + souAntic);
    }
}