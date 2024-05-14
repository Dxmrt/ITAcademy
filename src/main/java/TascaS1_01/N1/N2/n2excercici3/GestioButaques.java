package TascaS1_01.N1.N2.n2excercici3;

import java.util.ArrayList;

public class GestioButaques {

    private ArrayList<Butaca> butaques = new ArrayList<>();

    public ArrayList<Butaca> getButaques() {

        return butaques;

    }
    public Butaca cercarButaca(String persona, int fila, int seient) {
        for (Butaca b : butaques) {
            if (b.getFila() == fila && b.getSeient() == seient && (persona == null || b.getPersona().equals(persona))) {
                return b;
            }
        }
        return null;
    }
    public boolean afegirButaca(Butaca b) throws ExcepcioButacaOcupada {
        Butaca butacaExistent = cercarButaca(null, b.getFila(), b.getSeient());
        if (butacaExistent == null) {
            butaques.add(b);
            return true;
        } else {
            throw new ExcepcioButacaOcupada("La butaca de fila " + b.getFila() + " i seient " + b.getSeient() + " ja està ocupada.");
        }
    }
}