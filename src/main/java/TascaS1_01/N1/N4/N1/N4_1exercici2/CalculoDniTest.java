package TascaS1_01.N1.N4.N1.N4_1exercici2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculoDniTest {

    // Mètode que proporciona les dades de prova
    private static Stream<Arguments> dniProvider() {
        return Stream.of(
                Arguments.of(12345678, 'Z'),
                Arguments.of(85636357, 'C'),
                Arguments.of(50421195, 'C'),
                Arguments.of(36983187, 'S'),
                Arguments.of(64097259, 'P'),
                Arguments.of(17238291, 'K'),
                Arguments.of(17836152, 'C'),
                Arguments.of(18158912, 'K'),
                Arguments.of(31670363, 'F'),
                Arguments.of(24724385, 'Y')
        );
    }

    // Test parametritzat que comprova si el càlcul de la lletra és correcte
    @ParameterizedTest
    @MethodSource("dniProvider")
    void testCalculoLetraDni(int numeroDni, char letraEsperada) {
        assertEquals(letraEsperada, CalculoDni.calcularLetra(numeroDni));
    }
}




