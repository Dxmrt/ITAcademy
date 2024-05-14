package TascaS1_01.N1.N2.n2excercici3;

import java.util.Scanner;

public class MenuCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestioButaques gestioButaques = new GestioButaques();

        while (true) {
            System.out.println("\n*** MENÚ CINEMA ***\n");
            System.out.println("1. Mostrar butaques");
            System.out.println("2. Mostrar butaques per persona");
            System.out.println("3. Reservar butaca");
            System.out.println("4. Anular reserva de butaca");
            System.out.println("5. Anular reserva de butaques per persona");
            System.out.println("6. Sortir");
            System.out.print("Opció: ");

            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    mostrarButaques(gestioButaques);
                    break;
                case 2:
                    mostrarButaquesPersona(gestioButaques);
                    break;
                case 3:
                    reservarButaca(gestioButaques);
                    break;
                case 4:
                    anularReserva(gestioButaques);
                    break;
                case 5:
                    anularReservaPersona(gestioButaques);
                    break;
                case 6:
                    System.out.println("S’ha sortit de l’aplicació.");
                    return;
                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        }
    }

    //Funciones adicionales
    private static String llegirPersona(String missatge) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(missatge);

        return scanner.nextLine();

    }

    private static int llegirFila(String missatge) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(missatge);

        int fila = scanner.nextInt();

        scanner.nextLine();

        return fila;

    }

    private static int llegirSeient(String missatge) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(missatge);

        int seient = scanner.nextInt();

        scanner.nextLine();

        return seient;

    }

    private static void mostrarButaques(GestioButaques gestioButaques) {
        for (Butaca b : gestioButaques.getButaques()) {
            System.out.println(b);
        }
    }
    private static void mostrarButaquesPersona(GestioButaques gestioButaques) {
        String persona = llegirPersona("Introduïu el nom de la persona: ");

        for (Butaca b : gestioButaques.getButaques()) {
            if (b.getPersona().equals(persona)) {
                System.out.println(b);
            }
        }
    }
    private static void reservarButaca(GestioButaques gestioButaques) {
        String persona = llegirPersona("Introduïu el nom de la persona: ");
        int fila = llegirFila("Introduïu la fila: ");
        int seient = llegirSeient("Introduïu el seient: ");

        Butaca b = new Butaca(fila, seient, persona);

        try {
            gestioButaques.afegirButaca(b);
            System.out.println("Butaca reservada amb èxit.");
        } catch (ExcepcioButacaOcupada e) {
            System.out.println(e.getMessage());
        }
    }
    private static void anularReserva(GestioButaques gestioButaques) {
        int fila = llegirFila("Introduïu la fila de la butaca a anular: ");
        int seient = llegirSeient("Introduïu el seient de la butaca a anular: ");

        Butaca b = gestioButaques.cercarButaca(null, fila, seient);

        if (b != null) {
            gestioButaques.getButaques().remove(b);
            System.out.println("Butaca " + fila + "-" + seient + " anul·lada.");
        } else {
            System.out.println("No s’ha trobat cap butaca amb aquestes característiques.");
        }
    }
    private static void anularReservaPersona(GestioButaques gestioButaques) {
        String persona = llegirPersona("Introduïu el nom de la persona: ");

        for (int i =gestioButaques.getButaques().size() - 1; i >= 0; i--) {
            Butaca b = gestioButaques.getButaques().get(i);
            if (b.getPersona().equals(persona)) {
                gestioButaques.getButaques().remove(b);
            }
        }
        System.out.println("Butaques de " + persona + " anul·lades.");
    }
    }