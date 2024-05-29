package TascaS1_01.N1.N5.N1.N5_N1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxt {
    public static void readTxt(String arxiuPath) {
        File arxiu = new File(arxiuPath);

        try {
            FileReader fileReader = new FileReader(arxiu);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lines;

            while ((lines = bufferedReader.readLine()) != null) {
                System.out.println(lines);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
