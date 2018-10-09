import homework5.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Алексей on 09.10.2018.
 */
public class CalculatorWithNumbersTests {
    Calculator CalculatorWithNumbers = new Calculator(10, 2);

    @Test
    public void checkGetNumber1() {
        Assert.assertNotNull(CalculatorWithNumbers.getNumber1());
        Assert.assertEquals(10, CalculatorWithNumbers.getNumber1(), 0);
    }

    @Test
    public void checkGetNumber2() {
        Assert.assertNotNull(CalculatorWithNumbers.getNumber2());
        Assert.assertEquals(2, CalculatorWithNumbers.getNumber2(), 0);
    }

    @Test
    public void checkAdditionNumbers() {
        Assert.assertEquals(12,
                CalculatorWithNumbers.addition(CalculatorWithNumbers.getNumber1(), CalculatorWithNumbers.getNumber2())
        );
    }

    @Test
    public void checkSubtractionNumbers() {
        Assert.assertEquals(8,
                CalculatorWithNumbers.subtraction(CalculatorWithNumbers.getNumber1(), CalculatorWithNumbers.getNumber2())
        );
    }

    @Test
    public void checkMultiplicationNumbers() {
        Assert.assertEquals(20,
                CalculatorWithNumbers.multiplication(CalculatorWithNumbers.getNumber1(), CalculatorWithNumbers.getNumber2())
        );
    }

    @Test
    public void checkDivideNumbers() {
        Assert.assertEquals(5,
                CalculatorWithNumbers.divideInt(CalculatorWithNumbers.getNumber1(), CalculatorWithNumbers.getNumber2())
        );
    }
}
