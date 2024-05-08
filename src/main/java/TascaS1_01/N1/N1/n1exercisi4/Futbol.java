package TascaS1_01.N1.N1.N1exercisi4;

import java.util.Scanner;


class Futbol extends Noticia {
    private String competicion;
    private String club;
    private String jugador;
    private final int precioini = 300;
    private final int puntosini = 5;

    public Futbol(String titular, Redactor redactor, String competicion, String club, String jugador) {
        super(titular, redactor);
        this.competicion = competicion;
        this.club = club;
        this.jugador = jugador;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public static Futbol noticiaFutbol(Redactor redactor, String titular){

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe la competicion a la que hace referencia la noticia:");
        String competicio = sc.nextLine();

        System.out.println("Escribe el club al que pertenece la noticia:");
        String club = sc.nextLine();

        System.out.println("Escribe el jugador al que hace refrencia la noticia:");
        String jugador = sc.nextLine();

        return new Futbol(titular, redactor, competicio, club, jugador);
    }

    @Override
    public void calcularPrecioNoticia() {
        int precioFinal = 0;
        if (competicion.equalsIgnoreCase("Liga de Champions")) {
            precioFinal += 100;
        }
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {
            precioFinal += 100;
        }
        if (jugador.equalsIgnoreCase("Ferran Torres") || jugador.equalsIgnoreCase("Benzema")) {
            precioFinal += 50;
        }
        precioFinal = precioFinal + precioini;
        System.out.println("El precio total de la noticia es de: " + precioFinal + " €.");
    }

    @Override
    public void calcularPuntos() {
        int totalPuntos = 0;

        if (competicion.equalsIgnoreCase("Liga de Champions")) {
            totalPuntos += 3;
        } else if (competicion.equalsIgnoreCase("Liga")) {
            totalPuntos += 2;
        }
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {
            totalPuntos += 1;
        }
        if (jugador.equalsIgnoreCase("Ferran Torres") || jugador.equalsIgnoreCase("Benzema")) {
            totalPuntos += 1;
        }
        totalPuntos = totalPuntos + puntosini;

        System.out.println("El total de puntos es de: " + totalPuntos + " .");
    }
}