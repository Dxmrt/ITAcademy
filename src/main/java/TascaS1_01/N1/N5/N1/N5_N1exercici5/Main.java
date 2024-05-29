package TascaS1_01.N1.N5.N1.N5_N1exercici5;

import static TascaS1_01.N1.N5.N1.N5_N1exercici5.DirectoryDesserialitzar.desserialitzarDirectory;
import static TascaS1_01.N1.N5.N1.N5_N1exercici5.SerializeDirectory.serializeDirectory;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Sonia", 35);

        serializeDirectory(player);
        desserialitzarDirectory();
    }
}