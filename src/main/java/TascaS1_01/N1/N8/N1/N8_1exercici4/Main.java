package TascaS1_01.N1.N8.N1.N8_1exercici4;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> mesos = Arrays.asList(
                "Gener", "Febrer", "Març", "Abril", "Maig", "Juny",
                "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"
        );

        mesos.forEach(System.out::println); //Method reference
    }
}
