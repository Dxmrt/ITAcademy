package TascaS1_01.N1.N4.N1.N4_1exercici1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MesosAnysTest {

    @Test
    void testLlistaNoEsNulla() {
        List<String> mesos = MesosAnys.obtenirMesos();
        assertNotNull(mesos, "La llista de mesos no hauria de ser nul·la");
        System.out.println("Test no és nul: La llista no és nul·la");
    }

    @Test
    void testLlistaTe12Posicions() {
        List<String> mesos = MesosAnys.obtenirMesos();
        assertEquals(12, mesos.size(), "La llista de mesos hauria de tenir 12 posicions");
        System.out.println("Test 12 posicions: La llista té 12 posicions");
    }

    @Test
    void testPosicio8EsAgost() {
        List<String> mesos = MesosAnys.obtenirMesos();
        assertEquals("agost", mesos.get(7), "El mes a la posició 8 hauria de ser 'agost'");
        System.out.println("Test posició 8 és agost: La posició 8 és 'agost'");
    }
}
