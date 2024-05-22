package TascaS1_01.N1.N3.N1.N3_1_1exercisi1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Month> monthList = new ArrayList<>();
        monthList.add(new Month("Gener"));
        monthList.add(new Month("Febrer"));
        monthList.add(new Month("Març"));
        monthList.add(new Month("Abril"));
        monthList.add(new Month("Maig"));
        monthList.add(new Month("Juny"));
        monthList.add(new Month("Juliol"));
        monthList.add(new Month("Setembre"));
        monthList.add(new Month("Octubre"));
        monthList.add(new Month("Novembre"));
        monthList.add(new Month("Desembre"));

        System.out.println("Llista de mesos: " + monthList);

        monthList.add(7, new Month("Agost")); //Afegim Agost a la posicio 7
        System.out.println("Llista de mesos amb Agost: " + monthList);

        HashSet<Month> monthsSet = new HashSet<>(monthList); //Converteix ArrayList en un HashSet
        System.out.println(monthsSet);

        System.out.println("\nRecorre amb for");

        for (Month month : monthList) {
            System.out.println(month);
        }
        System.out.println("\nRecorre la llista amb un iterador:");
        Iterator<Month> iterator = monthList.iterator();
        if (iterator.hasNext()) {
            do {
                System.out.println(iterator.next());
            } while (iterator.hasNext());
        }


    }
}