package TascaS1_01.N1.N5.N1.N5_N1exercici4;

import java.util.Scanner;

import static TascaS1_01.N1.N5.N1.N5_N1exercici4.ReadTxt.readTxt;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introdueix la ruta del arxiu .txt a llegir:");
        String directori = entrada.nextLine();

        readTxt(directori);

        entrada.close();
    }
}