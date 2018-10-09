import homework5.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Алексей on 09.10.2018.
 */
public class CalculatorWithValuesTests {
    Calculator calculatorWithValues = new Calculator(25.5, 33.3);

    @Test
    public void checkGetValue1() {
        Assert.assertNotNull(calculatorWithValues.getValue1());
        Assert.assertEquals(25.5, calculatorWithValues.getValue1(), 0);
    }

    @Test
    public void checkGetValue2() {
        Assert.assertNotNull(calculatorWithValues.getValue2());
        Assert.assertEquals(33.3, calculatorWithValues.getValue2(), 0);
    }

    @Test
    public void checkAdditionValues() {
        Assert.assertEquals(58.8,
                calculatorWithValues.addition(calculatorWithValues.getValue1(), calculatorWithValues.getValue2()),
                0);
    }

    @Test
    public void checkSubtractionValues() {
        Assert.assertEquals(-8.3,
                calculatorWithValues.subtraction(calculatorWithValues.getValue1(), calculatorWithValues.getValue2()),
                1);
    }

    @Test
    public void checkMultiplicationValues() {
        Assert.assertEquals(849.15,
                calculatorWithValues.multiplication(calculatorWithValues.getValue1(), calculatorWithValues.getValue2()),
                0);
    }

    @Test
    public void checkDivideValues() {
        Assert.assertEquals(0.7657657657657658,
                calculatorWithValues.divide(calculatorWithValues.getValue1(), calculatorWithValues.getValue2()),
                0);
    }

}
