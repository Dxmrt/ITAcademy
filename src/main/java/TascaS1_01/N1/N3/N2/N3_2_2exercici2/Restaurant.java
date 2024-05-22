package TascaS1_01.N1.N3.N2.N3_2_2exercici2;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Restaurant implements Comparable<Restaurant> {
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


    // Sobrescrivim equals per saber si els dos restaurants són iguals i si tenen el mateix nom i punts
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

    // Implementem compareTo per ordenar els restaurants per nom i punts
    @Override
    public int compareTo(Restaurant other) {
        int nameComparison = this.nom.compareTo(other.nom);
        if (nameComparison == 0) {
            return Integer.compare(this.puntuacio, other.puntuacio);
        }
        return nameComparison;
    }

    // Sobrescrivim toString per visualitzar
    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", puntuacio=" + puntuacio +
                '}';
    }

    public static void main(String[] args) {
        Set<Restaurant> restaurants = new TreeSet<>();

        Restaurant r1 = new Restaurant("La Salseta", 5);
        Restaurant r2 = new Restaurant("La Salseta", 7);  // Mateix nom, puntuació diferent
        Restaurant r3 = new Restaurant("La Salseta", 5);  // Duplicat de r1
        Restaurant r4 = new Restaurant("El Blau", 5);
        Restaurant r5 = new Restaurant("El Blau", 4);
        Restaurant r6 = new Restaurant("El Blau", 6);

        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3); //Duplicat
        restaurants.add(r4);
        restaurants.add(r5);
        restaurants.add(r6);

        // Imprimim el conjunt per comprobar el contingut i l'ordre
        for (Restaurant r : restaurants) {
            System.out.println(r);
        }
    }
}
