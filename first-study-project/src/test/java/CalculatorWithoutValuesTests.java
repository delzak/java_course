import homework5.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Алексей on 09.10.2018.
 */
public class CalculatorWithoutValuesTests {
    Calculator calculatorWithoutValues = new Calculator();


    @Test
    public void checkGetValue1() {
        calculatorWithoutValues.setValue1(11.11);
        Assert.assertNotNull(calculatorWithoutValues.getValue1());
        Assert.assertEquals(11.11, calculatorWithoutValues.getValue1(), 0);
    }

    @Test
    public void checkGetValue2() {
        calculatorWithoutValues.setValue2(33.33);
        Assert.assertNotNull(calculatorWithoutValues.getValue2());
        Assert.assertEquals(33.33, calculatorWithoutValues.getValue2(), 0);
    }

    @Test
    public void checkGetNumber1() {
        calculatorWithoutValues.setNumber1(22);
        Assert.assertNotNull(calculatorWithoutValues.getNumber1());
        Assert.assertEquals(22, calculatorWithoutValues.getNumber1(), 0);
    }

    @Test
    public void checkGetNumber2() {
        calculatorWithoutValues.setNumber2(5);
        Assert.assertNotNull(calculatorWithoutValues.getNumber2());
        Assert.assertEquals(5, calculatorWithoutValues.getNumber2(), 0);
    }

    @Test
    public void checkAdditionIntNumber1Number2() {
        calculatorWithoutValues.setNumber1(12);
        calculatorWithoutValues.setNumber2(9);
        Assert.assertEquals(21, calculatorWithoutValues.additionIntNumber1Number2());
    }

    @Test
    public void checkAdditionDoubleValue1Value2() {
        calculatorWithoutValues.setValue1(12.12);
        calculatorWithoutValues.setValue2(9.09);
        Assert.assertEquals(21.21, calculatorWithoutValues.additionDoubleValue1Value2(), 0);
    }

    @Test
    public void checkSubtractionIntNumer1Number2() {
        calculatorWithoutValues.setNumber1(25);
        calculatorWithoutValues.setNumber2(14);
        Assert.assertEquals(11, calculatorWithoutValues.subtractionIntNumer1Number2());
    }

    @Test
    public void checkSubtractionDoubleValue1Value2() {
        calculatorWithoutValues.setValue1(33.33);
        calculatorWithoutValues.setValue2(21.21);
        Assert.assertEquals(12.12, calculatorWithoutValues.subtractionDoubleValue1Value2(), 1);
    }

    @Test
    public void checkMultiplicationIntNumber1Number2() {
        calculatorWithoutValues.setNumber1(33);
        calculatorWithoutValues.setNumber2(2);
        Assert.assertEquals(66, calculatorWithoutValues.multiplicationIntNumber1Number2());
    }

    @Test
    public void checkMultiplicationDoubleNumber1Number2() {
        calculatorWithoutValues.setValue1(1.5);
        calculatorWithoutValues.setValue2(11.21);
        Assert.assertEquals(16.815, calculatorWithoutValues.multiplicationDoubleValue1Value2(), 0);
    }

    @Test
    public void checkDivideIntNumber1Number2() {
        calculatorWithoutValues.setNumber1(15);
        calculatorWithoutValues.setNumber2(7);
        Assert.assertEquals(2, calculatorWithoutValues.divideIntNumber1Number2());
    }

    @Test
    public void checkDivideDoubleValue1Value2() {
        calculatorWithoutValues.setValue1(33.33);
        calculatorWithoutValues.setValue2(7.5);
        Assert.assertEquals(4.444, calculatorWithoutValues.divideDoubleValue1Value2(), 0);
    }

}
