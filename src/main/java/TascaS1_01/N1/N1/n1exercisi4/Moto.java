package TascaS1_01.N1.N1.N1exercisi4;

import java.util.Scanner;

class Moto extends Noticia {

    private String equipo;
    private final int precioini = 100;
    private final int puntosini = 3;

    public Moto(String titular, Redactor redactor, String equipo) {
        super(titular,redactor);
        this.equipo = equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public static Moto noticiaMotociclisme(Redactor redactor, String titular){

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe a que equipo hace referencia la noticia: ");
        String equip = sc.nextLine();

        return new Moto(titular,redactor,equip);
    }

    @Override
    public void calcularPrecioNoticia() {
        int precioFinal = 0;

        if (equipo.equalsIgnoreCase("Honda") || equipo.equalsIgnoreCase("Yamaha")) {
            precioFinal += 50;
        }
        precioFinal = precioFinal + precioini;

        System.out.println("El precio total de la noticia és de: " + precioFinal + " €.");
    }

    @Override
    public void calcularPuntos() {
        int totalPuntos = 0;

        if (equipo.equalsIgnoreCase("Honda") || equipo.equalsIgnoreCase("Yamaha")) {
            totalPuntos += 3;
        }
        totalPuntos = totalPuntos + puntosini;

        System.out.println("El total de puntos de la noticia es de: " + totalPuntos);
    }
}
