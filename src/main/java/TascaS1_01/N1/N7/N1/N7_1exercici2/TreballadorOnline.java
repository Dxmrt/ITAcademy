package TascaS1_01.N1.N7.N1.N7_1exercici2;

import TascaS1_01.N1.N7.N1.N7_1exercici1_2.Treballador;

public class TreballadorOnline extends Treballador {


    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }


    @Deprecated
    public void imprimirDetalls() {
        System.out.println("Nom: " + nom + "Cognom: " + cognom);
    }


}