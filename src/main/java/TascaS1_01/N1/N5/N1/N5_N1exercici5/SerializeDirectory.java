package TascaS1_01.N1.N5.N1.N5_N1exercici5;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDirectory {
    public static void serializeDirectory(Player player) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("player.ser"))) {

            out.writeObject(player);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
