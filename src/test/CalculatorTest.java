package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void getValue() {
        assertEquals(2, calc.getValue("dm"));
    }

    @Test
    void convertUnit() {
        assertEquals(10.0, calc.convertUnit(1, "m", "dm"));
    }

    @Test
    void calculate() {
        assertEquals("1090.0 mm", calc.calculate("10 cm + 1 m - 10 mm"));
    }
}