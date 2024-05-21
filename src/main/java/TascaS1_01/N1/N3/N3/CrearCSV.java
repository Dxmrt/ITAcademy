package TascaS1_01.N1.N3.N3;

import java.io.FileWriter;
import java.io.IOException;

public class CrearCSV {
    public static void main(String[] args) {
        String[] dades = {
                "Andreu,Ballestero Llenas,34835767J",
                "Miquel,Bayona Font,48743957B",
                "Guillem,Capdevila Riu,33957834J",
                "Albert,Carbonell Ferrer,77364986R",
                "Ferran,Casas Coderch,23047848P",
                "Maria,Casellas Fuste,47102244S",
                "Genis,Ciutat Vendrell,39718459N"
        };

        try (FileWriter writer = new FileWriter("persones.csv")) {
            for (String linia : dades) {
                writer.write(linia + "\n");
            }
            System.out.println("Fitxer persones.csv creat correctament.");
        } catch (IOException e) {
            System.out.println("Error creant el fitxer: " + e.getMessage());
        }
    }
}
