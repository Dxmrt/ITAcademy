package TascaS1_01.N1.N2.n2exercisi2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static byte llegirByte(String missatge) {
        try {
            System.out.println(missatge);
            return scanner.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("Error de format. Si us plau, introdueixi un byte.");
            scanner.nextLine(); // Neteja la línia
        }
        return llegirByte(missatge); // Repeteix la sol·licitud fins que s'introduïxi correctament
    }

    public static int llegirInt(String missatge) {
        try {
            System.out.println(missatge);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error de format. Si us plau, introdueixi un enter.");
            scanner.nextLine();
        }
        return llegirInt(missatge);
    }

    public static float llegirFloat(String missatge) {
        try {
            System.out.println(missatge);
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Error de format. Si us plau, introdueixi un nom flotant.");
            scanner.nextLine();
        }
        return llegirFloat(missatge);
    }

    public static double llegirDouble(String missatge) {
        try {
            System.out.println(missatge);
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error de format. Si us plau, introdueixi un numero de doble precisió.");
            scanner.nextLine();
        }
        return llegirDouble(missatge);
    }



    public static boolean llegirBoolean(String missatge) {
        try {
            System.out.println(missatge);
            String resposta = scanner.nextLine().trim().toLowerCase();
            return resposta.equals("t") || resposta.equals("true");
        } catch (Exception e) {
            System.out.println("Error de format. Si us plau, introdueixi t (per a true) o f (per a false).");
            scanner.nextLine();
        }
        return llegirBoolean(missatge);
    }

    public static char llegirChar(String missatge) {
        char letra = 0;
        do {
            System.out.println(missatge);
            String entrada = scanner.nextLine();
            if (entrada.matches("\\d+")) { // Comprova si l'entrada conté només nombres
                System.out.println("Error: La resposta ha de ser una lletra, no un nom.");
            } else {
                letra = entrada.charAt(0); // Obté la primera lletra de l'entrada
            }
        } while (letra == '\0'); // Repeteix la sol·licitud fins que l'usuari/ària ingressi una lletra
        return letra;
    }

    public static String llegirString(String missatge) {
        String nombre;
        do {
            System.out.println(missatge);
            nombre = scanner.nextLine();
            if (nombre.matches(".*\\d.*")) { // Comprova si el nombre conté nombres
                System.out.println("Error de format. Si us plau, introdueixi un nom.");
            }
        } while (nombre.matches(".*\\d.*")); // Repeteix la sol·licitud fins que l'usuari/ària ingressi un nombre vàlid
        return nombre;
    }
}

