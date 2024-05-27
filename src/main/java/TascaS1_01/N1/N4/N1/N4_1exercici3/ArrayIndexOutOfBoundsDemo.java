package TascaS1_01.N1.N4.N1.N4_1exercici3;

public class ArrayIndexOutOfBoundsDemo {

    // Mètode que llança una ArrayIndexOutOfBoundsException
    public void generarExcepcio() {
        int[] array = new int[5];
        // Accedint a una posició fora dels límits de l'array.
        int valor = array[10];
    }
}



