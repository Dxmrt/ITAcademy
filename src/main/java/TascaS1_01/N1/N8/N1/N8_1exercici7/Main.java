package TascaS1_01.N1.N8.N1.N8_1exercici7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Object> elements = Arrays.asList(7, "ordenador","sol","java", "lambda", "estrella");

        List<String> cadenesOrdenades = elements.stream()
                .filter(e -> e instanceof String)
                .map(e -> (String) e)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        cadenesOrdenades.forEach(System.out::println);
    }
}

