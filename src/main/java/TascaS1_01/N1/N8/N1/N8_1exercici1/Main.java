package TascaS1_01.N1.N8.N1.N8_1exercici1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hola", "adeu", "exercici", "java", "streams", "lambda", "opcio");
        List<String> resultat = filtraStringsAmbO(strings);
        resultat.forEach(System.out::println);
    }

    public static List<String> filtraStringsAmbO(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o"))
                .collect(Collectors.toList());
    }
}
