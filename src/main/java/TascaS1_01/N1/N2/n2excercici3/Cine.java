package TascaS1_01.N1.N2.n2excercici3;

import java.util.Scanner;

public class Cine {
    private int files;
    private int seientsPerFila;
    private GestioButaques gestioButaques;
    private Scanner scanner = new Scanner(System.in);

    public Cine() {
        this.gestioButaques = new GestioButaques();
        demanarDadesInicials();
    }

    public void iniciar() {
        menu();
    }

    private void menu() {
        int opcio = llegirInt("Escull el que voldries fer: \n1 - Mostrar les butaques reservades.\n2 - Mostrar les butaques reservades per una persona.\n3 - Reservar butaca.\n4 - Anular la reserva d'una butaca.\n5 - Anular les butaques reservades per una persona.\n6 - Surt.\n\nOpcio: ");
        mostrarOpcio(opcio);
    }

    private void mostrarButaques() {
        System.out.println("Butaques reservades: ");
        gestioButaques.getButaques().forEach(System.out::println);
        System.out.println("\n");
    }

    private void mostrarButaquesPersona() {
        String persona = llegirString("Persona: ");
        int fila = 0;
        int seient = 0;
        Butaca b = gestioButaques.cercarButaca(persona, fila, seient);
        if (b != null) {
            fila = b.getFila();
            seient = b.getSeient();
            System.out.println("Butaques reservades per " + persona + ": \n");
            while (b != null) {
                System.out.println(b);
                fila++;
                seient++;
                b = gestioButaques.cercarButaca(persona, fila, seient);
            }
            System.out.println("\n");
        } else {
            System.out.println("La persona " + persona + " no té butaques reservades.\n");
        }
    }
    private void reservarButaca() {
        int fila = llegirFila("Fila: ");
        int seient = llegirSeient("Seient: ");
        String persona = llegirPersona("Persona: ");
        try {
            gestioButaques.afegirButaca(new Butaca(fila, seient, persona));
            System.out.println("Butaca reservada.\n");
        } catch (ExcepcioButacaOcupada ex) {
            System.out.println(ex.getMessage() + "\n");
        }
    }
    private void anularReserva() {
        int fila = llegirFila("Fila: ");
        int seient = llegirSeient("Seient: ");
        Butaca b = gestioButaques.cercarButaca(null, fila, seient);
        if (b != null) {
            gestioButaques.getButaques().remove(b);
            System.out.println("Butaca anul·lada.\n");
        } else {
            System.out.println("Aquesta butaca no està reservada.\n");
        }
    }
    private void anularReservaPersona() {
        String persona = llegirPersona("Persona: ");
        int fila = 0;
        int seient = 0;
        Butaca b = gestioButaques.cercarButaca(persona, fila, seient);
        if (b != null) {
            fila = b.getFila();
            seient = b.getSeient();
            while (b != null) {
                gestioButaques.getButaques().remove(b);
                fila++;
                seient++;
                b = gestioButaques.cercarButaca(persona, fila, seient);
            }
            System.out.println("Butaques anul·lades per " + persona + ".\n");
        } else {
            System.out.println("La persona " + persona + " no té butaques reservades.\n");
        }
    }
    private void demanarDadesInicials() {
        System.out.println("Informació del cinema:");
        this.files = llegirInt("Nombre de files: ");
        this.seientsPerFila = llegirInt("Nombre de seients per fila: ");
    }
    private String llegirString(String missatge) {
        System.out.print(missatge);
        return scanner.nextLine();
    }
    private int llegirInt(String missatge) {
        System.out.print(missatge);
        return scanner.nextInt();
    }
    private String llegirPersona(String missatge) {
        String persona = llegirString(missatge);
        if (persona.matches(".\\d+.")) {
            try {
                throw new ExcepcioNomPersonaIncorrecte();
            } catch (ExcepcioNomPersonaIncorrecte e) {
                System.out.println(e.getMessage() + "El nom es incorrecte");
            }
        }
        return persona;
    }
    private int llegirFila(String missatge) {
        int fila = llegirInt(missatge);
        if (fila < 1 || fila > files) {
            try {
                throw new ExcepcioFilaIncorrecta();
            } catch (ExcepcioFilaIncorrecta e) {
                System.out.println(e.getMessage() + "La fila es incorrecta");
            }
        }
        return fila;
    }
    private int llegirSeient(String missatge) {
        int seient = llegirInt(missatge);
        if (seient < 1 || seient > seientsPerFila) {
            try {
                throw new ExcepcioSeientIncorrecte();
            } catch (ExcepcioSeientIncorrecte e) {
                System.out.println(e.getMessage() + "El seient es incorrecte");
            }
        }
        return seient;
    }
    private void mostrarOpcio(int opcio) {
        switch (opcio) {
            case 1:
                mostrarButaques();
                break;
            case 2:
                mostrarButaquesPersona();
                break;
            case 3:
                reservarButaca();
                break;
            case 4:
                anularReserva();
                break;
            case 5:
                anularReservaPersona();
                break;
            case 6:
                System.out.println("S’ha sortit de l’aplicació.");
                break;
            default:
                System.out.println("Opcio no vàlida.");
                break;
        }
    }
}