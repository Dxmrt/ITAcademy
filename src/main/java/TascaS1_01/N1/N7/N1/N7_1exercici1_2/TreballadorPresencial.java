package TascaS1_01.N1.N7.N1.N7_1exercici1_2;

public class TreballadorPresencial extends Treballador {
    private static final double BENZINA = 50.0;

    public TreballadorPresencial(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularSou(double horesTreballades) {
        return horesTreballades * preuHora + BENZINA;
    }


}
