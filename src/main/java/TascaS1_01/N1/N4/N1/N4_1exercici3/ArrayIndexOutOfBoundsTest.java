package TascaS1_01.N1.N4.N1.N4_1exercici3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayIndexOutOfBoundsTest {

    @Test
    void testGenerarExcepcio() {
        ArrayIndexOutOfBoundsDemo example = new ArrayIndexOutOfBoundsDemo();
        // Verificant que el mètode llança una ArrayIndexOutOfBoundsException.
        assertThrows(ArrayIndexOutOfBoundsException.class, example::generarExcepcio);
        System.out.println("Test excepció: S'ha llançat correctament ArrayIndexOutOfBoundsException");
    }
}

