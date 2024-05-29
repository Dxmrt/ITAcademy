package TascaS1_01.N1.N7.N1.N7_1exercici1_2;

public class TreballadorOnline extends Treballador {
    private static final double PREU_INTERNET = 30.0;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularSou(double horesTreballades) {

        return horesTreballades * preuHora + PREU_INTERNET;
    }
}