package TascaS1_01.N1.N2.n2exercisi2;

import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Utilitzar los metodos de las clases Entrada i Principal
        String nombre = Entrada.llegirString("Introduce tu nombre: ");
        char letra = Entrada.llegirChar("Introduce tu letra favorita: ");
        double doble = Entrada.llegirDouble("Introduce un numero de precision: ");
        int numero = Entrada.llegirInt("Introduce tu numero preferido: ");
        byte edad = Entrada.llegirByte("Introduce tu edad: ");
        float saldo = Entrada.llegirFloat("Introduce tu saldo: ");
        System.out.println("Introduce un valor booleano (T para \'true\' o F para \'false\'): ");
        boolean valorBooleano = Entrada.llegirBoolean("");
        System.out.println("El valor booleà introduït és: " + valorBooleano);


        if (edad != -1 && saldo != -1f) {
            System.out.println("Hola, " + nombre + "!" + " Su letra favorita es:  " + letra + " su numero de precision es: " + doble + " su edad es de " + edad + " años" + " su numero preferido es el " + numero + " y su saldo es de " + saldo + "€.");
        }

        scanner.close();
    }
}