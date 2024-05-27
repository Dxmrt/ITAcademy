package TascaS1_01.N1.N4.N1.N4_1exercici2;

public class CalculoDni {

    // Array amb les lletres corresponents als residus de 0 a 22.
    private static final char[] LETRAS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
            'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    // Mètode que calcula la lletra del DNI.
    public static char calcularLetra(int numeroDni) {
        int residuo = numeroDni % 23;
        return LETRAS[residuo];
    }
}



