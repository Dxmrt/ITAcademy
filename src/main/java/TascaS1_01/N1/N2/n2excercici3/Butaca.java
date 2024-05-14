package TascaS1_01.N1.N2.n2excercici3;

public class Butaca {
    private int fila;
    private int seient;
    private String persona;

    public Butaca(int fila, int seient, String persona) {
        this.fila = fila;
        this.seient = seient;
        this.persona = persona;
    }

    public int getFila() {
        return fila;
    }

    public int getSeient() {
        return seient;
    }

    public String getPersona() {
        return persona;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Butaca))
            return false;
        Butaca b = (Butaca) o;
        return b.fila == fila && b.seient == seient;
    }
    @Override
    public String toString() {
        return "Fila: " + fila + ", Seient: " + seient + ", Persona: " + persona;
    }
}