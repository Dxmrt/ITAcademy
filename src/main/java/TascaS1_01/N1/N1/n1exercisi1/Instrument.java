package TascaS1_01.N1.N1.n1exercici1;

public abstract class Instrument {
    protected String nom;
    protected float preu;

    public Instrument(String nom, float preu) {
            this.nom = nom;
            this.preu = preu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return "It's a " + this.nom + " and the price is " + this.preu + "€.";
    }

    public abstract String play();
}


