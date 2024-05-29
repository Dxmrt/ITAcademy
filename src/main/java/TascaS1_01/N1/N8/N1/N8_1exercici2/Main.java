package TascaS1_01.N1.N8.N1.N8_1exercici2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hola", "adeu", "exercici", "java", "streams", "lambda", "opcional");
        List<String> resultat = filtraStringsAmbOIMesDeCincLletres(strings);
        resultat.forEach(System.out::println);
    }

    public static List<String> filtraStringsAmbOIMesDeCincLletres(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o") && s.length() > 5)
                .collect(Collectors.toList());
    }
}

