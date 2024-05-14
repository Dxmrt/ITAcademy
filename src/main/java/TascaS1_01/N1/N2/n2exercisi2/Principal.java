package TascaS1_01.N1.N2.n2exercisi2;

import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Utilitzar los metodos de las clases Entrada i Principal
        String nombre = Entrada.llegirString("Introdueix el teu nom: ");
        char letra = Entrada.llegirChar("Introdueix la teva lletra preferida: ");
        double doble = Entrada.llegirDouble("Introdueix un numero de precisio: ");
        int numero = Entrada.llegirInt("Introdueix el teu numero preferit: ");
        byte edad = Entrada.llegirByte("Introdueix la teva edad: ");
        float saldo = Entrada.llegirFloat("Introdueix el teu saldo: ");
        boolean valorBooleano = Entrada.llegirBoolean("Introdueix true T or false F: ");



        if (edad != -1 && saldo != -1f) {
            System.out.println("Hola, " + nombre + "!" + " la teva lletra preferida es: " + letra + " el seu numero de precisio es: " + doble + " la seva edad es de " + edad + " anys" + " el seu numero preferit es el " + numero + " i el seu saldo es de " + saldo + "€." + "el valor boolean es: " + valorBooleano);
        }

        scanner.close();
    }
}