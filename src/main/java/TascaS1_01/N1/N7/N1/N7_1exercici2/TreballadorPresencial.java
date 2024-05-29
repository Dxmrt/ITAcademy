package TascaS1_01.N1.N7.N1.N7_1exercici2;

import TascaS1_01.N1.N7.N1.N7_1exercici1_2.Treballador;

public class TreballadorPresencial extends Treballador {
    private static final double BENZINA = 50.0;

    public TreballadorPresencial(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }



    @Deprecated
    public double calcularSouAntic(double horesTreballades) {
        return horesTreballades * getPreuHora();
    }


    public double getPreuHora() {
        return preuHora;
    }


}
