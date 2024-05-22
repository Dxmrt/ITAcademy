package TascaS1_01.N1.N3.N1.N3_1_2exercisi2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Llista {
    public static void main(String[] args) {

        // Crea la primera llista
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);

        List<Integer> secondList = new ArrayList<>();

        ListIterator<Integer> iterator = firstList.listIterator(firstList.size());
        int i = 0;
        while (iterator.hasPrevious()) {
            secondList.add(i, iterator.previous());
            i++;
        }

        System.out.println("Primera llista: " + firstList);
        System.out.println("Segona llista (ordre invers): " + secondList);
    }
}