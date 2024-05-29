package TascaS1_01.N1.N7.N1.N7_1exercici1_2;

public class Principal {

    public static void main(String[] args) {
        TreballadorOnline online = new TreballadorOnline("Roger", "Carreras", 12.5);
        TreballadorPresencial presencial = new TreballadorPresencial("Aina", "Rodriguez", 15.0);

        double souOnline = online.calcularSou(160);
        System.out.println("Sou del treballador online: " + souOnline);

        double souPresencial = presencial.calcularSou(200);
        System.out.println("Sou del treballador presencial: " + souPresencial);


    }
    }


