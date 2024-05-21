package TascaS1_01.N1.N3.N3;

import java.io.*;
import java.util.*;

public class Principal {

    private static List<Persona> llegirCSV(String nomFitxer) {
        List<Persona> persones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomFitxer))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dades = linia.split(",");
                if (dades.length == 3) {
                    persones.add(new Persona(dades[0], dades[1], dades[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer: " + e.getMessage());
        }
        return persones;
    }

    private static void introduirPersona(List<Persona> persones) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom: ");
        String nom = scanner.nextLine();
        System.out.print("Introdueix el cognom: ");
        String cognom = scanner.nextLine();
        System.out.print("Introdueix el DNI: ");
        String dni = scanner.nextLine();
        persones.add(new Persona(nom, cognom, dni));
    }

    private static void mostrarPersones(List<Persona> persones) {
        System.out.println(String.format("Nom", "Cognoms", "DNI"));
        for (Persona persona : persones) {
            System.out.println(persona);
        }
    }

    public static void main(String[] args) {
        List<Persona> persones = llegirCSV("persones.csv");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.- Introduir persona.");
            System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
            System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
            System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
            System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
            System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
            System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
            System.out.println("8.- Sortir.");
            System.out.print("Escull una opció: ");

            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    introduirPersona(persones);
                    break;
                case 2:
                    persones.sort(Comparator.comparing(Persona::getNom));
                    mostrarPersones(persones);
                    break;
                case 3:
                    persones.sort(Comparator.comparing(Persona::getNom).reversed());
                    mostrarPersones(persones);
                    break;
                case 4:
                    persones.sort(Comparator.comparing(Persona::getCognom));
                    mostrarPersones(persones);
                    break;
                case 5:
                    persones.sort(Comparator.comparing(Persona::getCognom).reversed());
                    mostrarPersones(persones);
                    break;
                case 6:
                    persones.sort(Comparator.comparing(Persona::getDni));
                    mostrarPersones(persones);
                    break;
                case 7:
                    persones.sort(Comparator.comparing(Persona::getDni).reversed());
                    mostrarPersones(persones);
                    break;
                case 8:
                    System.out.println("Sortint...");
                    return;
                default:
                    System.out.println("Opció no vàlida, si us plau tria una altra opció.");
            }
        }
    }
}
