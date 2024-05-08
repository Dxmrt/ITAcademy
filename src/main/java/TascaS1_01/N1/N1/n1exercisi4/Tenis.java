package TascaS1_01.N1.N1.N1exercisi4;

import java.util.Scanner;

class Tenis extends Noticia {
    private String competicio;
    private String tenistes;
    private final int PREU_INICIAL = 150;
    private final int PUNTS_INICIAL = 4;

    public Tenis(String titular, Redactor redactor, String competicio, String tenistes) {
        super(titular, redactor);
        this.competicio = competicio;
        this.tenistes = tenistes;
    }

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public String getTenistes() {
        return tenistes;
    }

    public void setTenistes(String tenistes) {
        this.tenistes = tenistes;
    }

    public static Tenis noticiaTenis(Redactor redactor, String titular) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escriu la competició a la que fa referència la notícia:");
        String competicio = sc.nextLine();

        System.out.println("Escriu els tenistes als que fa referència la notícia:");
        String tenistes = sc.nextLine();

        return new Tenis(titular, redactor, competicio, tenistes);

    }

    @Override
    public void calcularPrecioNoticia() {
        int preuFinal = 0;

        if (tenistes.equalsIgnoreCase("Federer") || tenistes.equalsIgnoreCase("Nadal") ||
                tenistes.equalsIgnoreCase("Djokovic")) {
            preuFinal += 100;
        }
        preuFinal = preuFinal + PREU_INICIAL;

        System.out.println("El precio total de la noticia és de: " + preuFinal + " euros.");
    }

    @Override
    public void calcularPuntos() {
        int totalPunts = 0;

        if (tenistes.equalsIgnoreCase("Federer") || tenistes.equalsIgnoreCase("Nadal") ||
                tenistes.equalsIgnoreCase("Djokovic")) {
            totalPunts += 3;
        }
        totalPunts = totalPunts + PUNTS_INICIAL;

        System.out.println("El total de punts de la noticia és de: " + totalPunts);
    }
}

