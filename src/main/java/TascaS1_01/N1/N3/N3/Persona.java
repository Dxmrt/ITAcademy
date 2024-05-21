package TascaS1_01.N1.N3.N3;

public class Persona {
    private final String nom;
    private final String cognom;
    private final String dni;

    public Persona(String nom, String cognom, String dni) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-20s %-10s", nom, cognom, dni);
    }
}
