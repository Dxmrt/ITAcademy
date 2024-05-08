package TascaS1_01.N1.N1.N1exercisi4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

    private static List<Redactor> listaRedactors = new ArrayList<>();

    public static void iniciarMenu() {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("""
                    Menu. \s
                    1. Introducir redactor. \s
                    2. Eliminar redactor. \s
                    3. Introducir notícia de un redactor. \s
                    4. Eliminar notícia. \s
                    5. Mostrar las noticias por redactor. \s
                    6. Calcular puntuación de la noticia. \s
                    7. Calcular precio de la noticia. \s
                    8. Exit.""");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    introducirRedactor(sc);
                    break;
                case 2:
                    eliminarRedactor(sc);
                    break;
                case 3:
                    introducirNoticia(sc);
                    break;
                case 4:
                    eliminarNoticia(sc);
                    break;
                case 5:
                    mostrarNoticias(sc);
                    break;
                case 6:
                    puntuacionNoticia(sc);
                    break;
                case 7:
                    precioNoticia(sc);
                    break;
            }

        } while (opcion != 8);
    }

    public static void introducirRedactor(Scanner sc) {

        System.out.println("Escribe el nombre del redactor:");
        String nombre = sc.nextLine();

        System.out.println("Escribe el DNI del redactor:");
        String dni = sc.nextLine();

        // Crear una instancia de Redactor
        Redactor nuevoRedactor = new Redactor(nombre, dni);

        // Utilizar setter para establecer atributos
        nuevoRedactor.setNombre(nombre);
        nuevoRedactor.setDni(dni);

        // Agregar el redactor a la lista
        listaRedactors.add(nuevoRedactor);

        // Utilizar getter para obtener atributos
        String nombreObtenido = nuevoRedactor.getNombre();
        String dniObtenido = nuevoRedactor.getDni();

        System.out.println("Se ha introducido el redactor: " + nombreObtenido + ", con DNI: " + dniObtenido + ".");
    }

    public static String eliminarRedactor(Scanner sc) {

        System.out.println("Escribe el nombre del redactor a eliminar: ");
        String redactorEliminar = sc.nextLine();

        for (Redactor redactor : listaRedactors) {
            if (redactorEliminar.equalsIgnoreCase(redactor.getNombre())) {
                listaRedactors.remove(redactor);
                return "El redactor se ha eliminado correctamente";
            }
        }
        return "No se ha encontrado el redactor.";
    }

    public static void introducirNoticia(Scanner sc) {

        Redactor redactorEncontrado = encontrarRedactor(sc, "Escribe el nombre del redactor de la noticia:");

        System.out.println("Escribe el titular de la noticia: ");
        String titular = sc.nextLine();

        int opcion = 0;

        do {
            System.out.println("""
                    Escoge el tipo de categoria:\s
                    1. Futbol.\s
                    2. Basket\s
                    3. Tenis\s
                    4. F1\s
                    5. Motociclismo\s
                    6. Exit.""");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    redactorEncontrado.getListaNoticias().add(Futbol.noticiaFutbol(redactorEncontrado, titular));

                    break;
                case 2:
                    redactorEncontrado.getListaNoticias().add(Basket.noticiaBasket(redactorEncontrado, titular));

                    break;
                case 3:
                    redactorEncontrado.getListaNoticias().add(Tenis.noticiaTenis(redactorEncontrado, titular));

                    break;
                case 4:
                    redactorEncontrado.getListaNoticias().add(F1.noticiaF1(redactorEncontrado, titular));

                    break;
                case 5:
                    redactorEncontrado.getListaNoticias().add(Moto.noticiaMotociclisme(redactorEncontrado, titular));

                    break;
                case 6:
                    System.out.println("Operación cancelada.");

                    break;
            }
        } while (opcion != 6);
    }


    public static String eliminarNoticia(Scanner sc) {

        System.out.println("Escribe el nombre del redactor de la noticia a eliminar: ");
        String selecRedactor = sc.nextLine();

        System.out.println("Escribe el titular de la noticia a eliminar: ");
        String eliminarTitular = sc.nextLine();

        for (Redactor redactor : listaRedactors) {
            if (selecRedactor.equalsIgnoreCase(redactor.getNombre())) {
                List<Noticia> listaNoticias = redactor.getListaNoticias();
                for (Noticia noticia : listaNoticias) {
                    if (eliminarTitular.equalsIgnoreCase(noticia.getTitular())) {
                        listaNoticias.remove(noticia);
                        redactor.setListaNoticias(listaNoticias);
                        return "Se ha eliminado correctamente la noticia.";
                    }
                }
            }
        }
        return "No se ha podido eliminar la noticia.";
    }

    public static void mostrarNoticias(Scanner sc) {

        Redactor redactorEncontrado = encontrarRedactor(sc, "Escribe el nombre del redactor para visualizar sus noticias");

        System.out.println(redactorEncontrado.toString());
    }

    public static void puntuacionNoticia(Scanner sc) {

        Redactor redactorEncontrado = encontrarRedactor(sc, "Escribe el nombre del redactor para calcular sus puntos:");

        Noticia noticiaTitular = encontrarNoticia(sc, "Escribe el titular de la noticia que desees calcular: ", redactorEncontrado);

        noticiaTitular.calcularPuntos();
    }

    public static void precioNoticia(Scanner sc) {

        Redactor redactorEncontrado = encontrarRedactor(sc, "Escribe el nombre del redactor para visualizar el precio:");

        Noticia noticiaTitular = encontrarNoticia(sc, "Escribe el titular de la noticia que desees calcular: ", redactorEncontrado);

        noticiaTitular.calcularPrecioNoticia();
    }

    public static Redactor encontrarRedactor(Scanner sc, String text) {

        System.out.println(text);
        String redactorEncontrar = sc.nextLine();

        for (Redactor redactor : listaRedactors) {
            if (redactorEncontrar.equalsIgnoreCase(redactor.getNombre())) {
                return redactor;
            }
        }
        return null;
    }

    public static Noticia encontrarNoticia(Scanner sc, String text, Redactor redactor) {

        System.out.println(text);
        String noticiaEncontrar = sc.nextLine();

        for (Noticia noticia : redactor.getListaNoticias()) {
            if (noticiaEncontrar.equalsIgnoreCase(noticia.getTitular())) {
                return noticia;
            }
        }
        return null;
    }
}