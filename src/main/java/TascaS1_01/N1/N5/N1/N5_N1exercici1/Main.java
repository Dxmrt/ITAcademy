package TascaS1_01.N1.N5.N1.N5_N1exercici1;

import java.util.Scanner;

import static TascaS1_01.N1.N5.N1.N5_N1exercici1.DirectoryList.listDirectory;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introdueix la ruta del directori:");
        String directori = entrada.nextLine();

        listDirectory(directori);

        entrada.close();
    }

}
