package TascaS1_01.N1.N1.N1exercisi4;

import java.util.Scanner;

class F1 extends Noticia {

    private String escuderia;
    private final int precioini = 100;
    private final int puntosini = 4;

    public F1(String titular, Redactor redactor, String escuderia) {
        super(titular, redactor);
        this.escuderia = escuderia;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public static F1 noticiaF1(Redactor redactor, String titular){

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe la escuderia correspondiente: ");
        String escuderia = sc.nextLine();

        return new F1(titular, redactor, escuderia);
    }

    @Override
    public void calcularPrecioNoticia() {
        int precioFinal = 0;

        if (escuderia.equalsIgnoreCase("Ferrari") || escuderia.equalsIgnoreCase("Mercedes")) {
            precioFinal += 50;
        }
        precioFinal = precioFinal + precioini;

        System.out.println("El precio de la noticia és de: " + precioFinal + " €.");
    }

    @Override
    public void calcularPuntos() {
        int totalPuntos = 0;

        if (escuderia.equalsIgnoreCase("Ferrari") || escuderia.equalsIgnoreCase("Mercedes")) {
            totalPuntos += 2;
        }
        totalPuntos = totalPuntos + puntosini;

        System.out.println("La noticia tiene: " + totalPuntos + " puntos");
    }
}