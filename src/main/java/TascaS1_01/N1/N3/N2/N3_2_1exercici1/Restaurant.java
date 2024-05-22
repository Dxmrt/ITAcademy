package TascaS1_01.N1.N3.N2.N3_2_1exercici1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Restaurant {
    private final String nom;
    private final int puntuacio;

    // Constructor
    public Restaurant(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    // Getters
    public String getNom() {
        return nom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return puntuacio == that.puntuacio && Objects.equals(nom, that.nom);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nom, puntuacio);
    }

    // Sobrescrivim toString per visualitzar els objectes
    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", puntuacio=" + puntuacio +
                '}';
    }

    public static void main(String[] args) {
        Set<Restaurant> restaurants = new HashSet<>();

        Restaurant r1 = new Restaurant("La Salseta", 5);
        Restaurant r2 = new Restaurant("La Salseta", 5);  // Duplicat
        Restaurant r3 = new Restaurant("El Blau", 4);  // Mateix nom, puntuacio diferent
        Restaurant r4 = new Restaurant("El Blau", 5);

        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
        restaurants.add(r4);

        // Imprimim el conjunt per verificar el contingut
        for (Restaurant r : restaurants) {
            System.out.println(r);
        }
    }
}


