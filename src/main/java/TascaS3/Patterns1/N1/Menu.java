package TascaS3.Patterns1.N1;


import java.util.Scanner;

public class Menu {

    public static void printearMenu() {
        Scanner scan = new Scanner(System.in);
        Undo undo = Undo.getInstance();
        boolean running = true;

        while (running) {
            System.out.println("\n***Menu***\n");
            System.out.println("1. Añadir comanda");
            System.out.println("2. Eliminar comanda");
            System.out.println("3. Mostrar lista comandas");
            System.out.println("4. Salir");

            switch (scan.nextInt()) {
                case 1:
                    scan.nextLine(); // Consumir la nueva línea
                    System.out.println("Añadir comanda");
                    String command = scan.nextLine();
                    undo.addCommand(command);
                    break;
                case 2:
                    undo.listCommands();
                    System.out.println("Eliminar comanda");
                    System.out.println("Ingrese el índice de la comanda a eliminar:");
                    int index = scan.nextInt() - 1; // Convertir a índice basado en 0
                    scan.nextLine(); //Clear
                    undo.removeCommand(index);
                    break;
                case 3:
                    undo.listCommands();
                    break;
                case 4:
                    System.out.println("Salir");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida, vuelvalo a intentar de nuevo.");
            }
        }
        scan.close();
    }
}
