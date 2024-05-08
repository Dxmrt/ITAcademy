package TascaS1_01.N1.N1.N1exercisi4;


import java.util.Scanner;

public class Basket extends Noticia {
    private String competicion;
    private String club;
    private final int precioini = 250;
    private final int puntosini = 4;

    public Basket(String titular, Redactor redactor, String competicion, String club) {
        super(titular, redactor);
        this.competicion = competicion;
        this.club = club;
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

    public static Basket noticiaBasket(Redactor redactor, String titular){

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe la competicion a la que hace referencia la noticia: ");
        String competicion = sc.nextLine();

        System.out.println("Escribe el club al que hace referencia la noticia: ");
        String club = sc.nextLine();

        return new Basket(titular,redactor,competicion, club);
    }

    @Override
    public void calcularPrecioNoticia() {
        int precioFinal = 0;

        if (competicion.equalsIgnoreCase("Euroliga")) {
            precioFinal += 75;
        }
        if (club.equalsIgnoreCase("Madrid") || club.equalsIgnoreCase("Barça")) {
            precioFinal += 75;
        }
        precioFinal = precioFinal + precioini;

        System.out.println("El precio total de la noticia es de: " + precioFinal + " €.");
    }

    @Override
    public void calcularPuntos() {
        int totalPuntos = 0;

        if (competicion.equalsIgnoreCase("Euroliga")) {
            totalPuntos += 3;

        } else if (competicion.equalsIgnoreCase("ACB")) {
            totalPuntos += 2;
        }
        if (club.equalsIgnoreCase("Madrid") || club.equalsIgnoreCase("Barça")) {
            totalPuntos += 1;
        }
        totalPuntos = totalPuntos + puntosini;

        System.out.println("El total de puntos de la noticia es de: " + totalPuntos);
    }
}

