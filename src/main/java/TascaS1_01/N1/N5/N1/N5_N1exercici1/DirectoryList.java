package TascaS1_01.N1.N5.N1.N5_N1exercici1;

import java.io.File;
import java.util.Arrays;

public class DirectoryList {
    public static void listDirectory(String dir) {

        File directori = new File(dir);
        File[] files = directori.listFiles();

        if (files != null) {
            Arrays.sort(files);

            for (File file : files) {
                System.out.println(file.getName());
            }

        } else {
            System.out.println("El directorio está vacío o no existe.");
        }
    }
}
