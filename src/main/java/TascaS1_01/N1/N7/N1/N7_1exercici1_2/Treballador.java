package TascaS1_01.N1.N7.N1.N7_1exercici1_2;

public class Treballador {
    protected String nom;
    protected String cognom;
    protected double preuHora;

    public Treballador(String nom, String cognom, double preuHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuHora = preuHora;
    }

    public double calcularSou(double horesTreballades) {

        return horesTreballades * preuHora;
    }
}





