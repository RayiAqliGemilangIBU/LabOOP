import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {
    SimpleCalculator calc = new SimpleCalculator();

    @Test
    void testCalculator() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(6, calc.subtract(10, 4));
        assertEquals(12, calc.multiply(3, 4));
        assertEquals(5, calc.divide(10, 2));
        assertThrows(ArithmeticException.class, () -> calc.divide(4, 0));
        assertTrue(calc.isEven(8));
        assertFalse(calc.isEven(7));
        assertEquals(9, calc.max(9, 4));
    }
}
