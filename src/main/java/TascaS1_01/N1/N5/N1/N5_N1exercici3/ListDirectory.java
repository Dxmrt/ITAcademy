package TascaS1_01.N1.N5.N1.N5_N1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class ListDirectory {
    public static void listDirectory(String dir, int level, String desti) {

        File directori = new File(dir);
        File[] files = directori.listFiles();

        if (files != null) {
            Arrays.sort(files);

            for (File file : files) {
                Date data = new Date(file.lastModified());

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(desti + "\\result_listing.txt", true))) {

                    if (file.isDirectory()) {

                        for (int i = 0; i < level; i++) {
                            writer.write("/ / ");
                        }

                        writer.write("[D] " + file.getName() + " - Ultima modificacio: " + data);

                    } else {

                        for (int i = 0; i < level; i++) {
                            writer.write("/ / ");
                        }

                        writer.write("[F] " + file.getName() + " - Ultima modificacio: " + data);
                    }

                    writer.newLine();

                } catch (IOException e) {
                    System.out.println("Error: " + e);
                }

                if (file.isDirectory()) {
                    listDirectory(file.getPath(), level + 1, desti);
                }
            }
        } else {
            System.out.println("El directori es troba buit o no existeix.");
        }
    }
}
