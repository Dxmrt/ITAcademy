package TascaS1_01.N1.N7.N1.N7_1exercici2;

@SuppressWarnings("deprecation")
public class Principal {
    public static void main(String[] args) {

        TreballadorOnline treballadorOnline = new TreballadorOnline("Laura","Hernandez", 22);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Jose","Gutierrez", 56);


        System.out.println("Sou del treballador online: " + treballadorOnline.calcularSou(120));
        System.out.println("Sou del treballador prsencial: " + treballadorPresencial.calcularSou(180));


        @SuppressWarnings("deprecation")
        double souOnline = treballadorOnline.calcularSouOnline(120);
        @SuppressWarnings("deprecation")
        double souPresencial = treballadorPresencial.calcularSouPresencial(180);

        System.out.println("Sous previous actualizacio:");
        System.out.println("Treballador online: " + souOnline);
        System.out.println("Treballador presencial: " + souPresencial);
    }
}