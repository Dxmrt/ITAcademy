package TascaS1_01.N1.N5.N1.N5_N1exercici3;

import java.util.Scanner;

import static TascaS1_01.N1.N5.N1.N5_N1exercici3.ListDirectory.listDirectory;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introdueix la ruta del directori:");
        String directorio = entrada.nextLine();

        System.out.println("Introdueix la ruta on vols que es guardi el fitxer:");
        String desti = entrada.nextLine();

        listDirectory(directorio, 0, desti);

        entrada.close();
    }

}