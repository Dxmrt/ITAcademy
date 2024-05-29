package TascaS1_01.N1.N5.N1.N5_N1exercici5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DirectoryDesserialitzar {
    public static void desserialitzarDirectory() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("player.dat"))) {
            Player person = (Player) in.readObject();

            System.out.println(person.toString());

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
