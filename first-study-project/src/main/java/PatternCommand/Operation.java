package PatternCommand;

/**
 * Created by Алексей on 25.11.2018.
 */
public class Operation {
    private Command add;
    private Command substract;
    private Command multiply;
    private Command divide;


    public Operation (Command add, Command substract, Command multiply, Command divide) {
        this.add = add;
        this.substract = substract;
        this.multiply = multiply;
        this.divide = divide;
    }

    public void addition(double firstNumber, double secondNumber){
        System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
        add.execute();
    }

    public void substraction(double firstNumber, double secondNumber){
        System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
        substract.execute();
    }

    public void multiplication(double firstNumber, double secondNumber){
        System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
        multiply.execute();
    }

    public void division(double firstNumber, double secondNumber){
        System.out.println(firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));
        divide.execute();
    }
}

