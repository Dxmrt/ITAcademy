package TascaS1_01.N1.N7.N1.N7_1exercici2;

import TascaS1_01.N1.N7.N1.N7_1exercici1_2.Treballador;

public class TreballadorOnline extends Treballador {
    private static final double PREU_INTERNET = 30.0;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    public double calcularSouOnline(double horesTreballades, int i) {

        return horesTreballades * preuHora + PREU_INTERNET;
    }
}