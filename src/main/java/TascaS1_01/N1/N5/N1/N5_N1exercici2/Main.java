package TascaS1_01.N1.N5.N1.N5_N1exercici2;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introdueix la ruta del directori:");
        String directori = entrada.nextLine();

        listDirectory(directori, 0);

        entrada.close();
    }

    private static void listDirectory(String dir, int level) {

        File directori = new File(dir);
        File[] files = directori.listFiles();

        if (files != null) {
            Arrays.sort(files);

            for (File file : files) {
                Date data = new Date(file.lastModified());

                if(file.isDirectory()) {

                    for(int i = 0; i < level; i++){
                        System.out.print("/ / ");
                    }

                    System.out.println("[D] " + file.getName() + " - Ultima modificacio: " + data);

                } else {

                    for(int i = 0; i < level; i++){
                        System.out.print("/ / ");
                    }

                    System.out.println("[F] " + file.getName() + " - Ultima modificacio: " + data);
                }

                if(file.isDirectory()) {
                    listDirectory(file.getPath(), level + 1);
                }
            }
        } else {
            System.out.println("El directori esta buit o no existeix.");
        }
    }
}
