package homework5;

/**
 * Created by Алексей on 20.09.2018.
 */
public class Calculator {
    private double value1, value2;
    private int number1, number2;

    //costructor
    public Calculator(){}

    public Calculator(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public Calculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    //getters and setters
    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    //operations
    public int addition(int add1, int add2) {
        return add1 + add2;
    }

    public double addition(double add1, double add2) {
        return add1 + add2;
    }

    public int additionIntNumber1Number2() {
        return getNumber1() + getNumber2();
    }

    public double additionDoubleValue1Value2() {
        return getValue1() + getValue2();
    }

    public int subtraction(int minued, int subtrahend) {
        return minued - subtrahend;
    }

    public double subtraction(double minued, double subtrahend) {
        return minued - subtrahend;
    }

    public int subtractionIntNumer1Number2() {
        return getNumber1() - getNumber2();
    }

    public double subtractionDoubleValue1Value2() {
        return getValue1() - getValue2();
    }

    public int multiplication(int multiplied1, int multiplied2) {
        return multiplied1*multiplied2;
    }

    public double multiplication(double multiplied1, double multiplied2) {
        return multiplied1*multiplied2;
    }

    public int multiplicationIntNumber1Number2() {
        return getNumber1()*getNumber2();
    }

    public double multiplicationDoubleValue1Value2() {
        return getValue1()*getValue2();
    }

    public int divideInt(int dividend, int divider) {
        return dividend/divider;
    }

    public double divide(double dividend, double divider) {
        return dividend/divider;
    }

    public int divideIntNumber1Number2() {
        return getNumber1()/getNumber2();
    }

    public double divideDoubleValue1Value2() {
        return getValue1()/getValue2();
    }

    public void getException() {
        try
        {
            System.out.println((Integer.parseInt("asd")/Integer.parseInt("sdf")));
        } catch (NumberFormatException e) {
            System.out.println("Один из элементов указан неверно! " + e.getMessage());
        }
    }
}
