package TascaS1_01.N1.N3.N2.N3_2_1exercici1;

import java.util.HashSet;
import java.util.Set;

public class RestaurantApp {
    public static void main(String[] args) {
        Set<Restaurant> restaurants = new HashSet<>();  // Declare and initialize restaurants

        Restaurant r1 = new Restaurant("La Tasca", 9);
        Restaurant r2 = new Restaurant("La Tasca", 6);
        Restaurant r3 = new Restaurant("La Tasca", 9);
        Restaurant r4 = new Restaurant("El Celler", 4);

        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
        restaurants.add(r4);

        // Mostrar restaurants
        for (Restaurant r : restaurants) {
            System.out.println("Nom: " + r.getNom() + ", Puntuació: " + r.getPuntuacio());
        }


    }
}
