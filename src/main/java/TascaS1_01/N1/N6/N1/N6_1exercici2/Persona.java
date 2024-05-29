package TascaS1_01.N1.N6.N1.N6_1exercici2;

public class Persona {
    String nom;
    String cognom;
    int edat;

    public Persona(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    @Override
    public String toString() {
        return String.format("Persona: Nom: %s, Cognom: %s, Edat: %s]", nom, cognom, edat);
    }
}





