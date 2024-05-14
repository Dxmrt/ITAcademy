package TascaS1_01.N1.N1.n1exercici1;

public class Rope extends Instrument{
    public Rope(String nom, float preu){
        super(nom,preu);
    }

    @Override
    public String play() {
        return "A rope instrument is beging played";
    }
}
