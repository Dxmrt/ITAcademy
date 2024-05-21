package TascaS1_01.N1.N3.N2.N3_2_2exercici2;

import java.util.*;

public class Restaurant implements Comparable<Restaurant> {
    private final String nom;
    private final int puntuacio;


    public Restaurant(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;


    }

    public String getNom() {
        return nom;
    }




@Override
public int compareTo(Restaurant other) {
    return -1 * Integer.compare(this.puntuacio, other.puntuacio);
}

@Override
public String toString() {
    return String.format("Nom: %s, Puntuació: %d", nom, puntuacio);
}

// Mostra els restaurants ordenats per puntuació
public static String mostrarRestaurants(Set<Restaurant> restaurants) {
    // Ordena els restaurants
    List<Restaurant> restaurantList = new ArrayList<>(restaurants);
    Collections.sort(restaurantList);

    // Imprimeix la llista ordenada
    restaurantList.forEach(System.out::println);
    return null;
}
}

