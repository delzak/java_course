package PatternCommand;

/**
 * Created by Алексей on 25.11.2018.
 */
public class TestCommand {
    public static void main (String[] args){
        Calc calc = new Calc();
        Command add = new AddCommand(calc);
        Command substract = new SubstractCommand(calc);
        Command multiply = new MultiplyCommand(calc);
        Command divide = new DivideCommand(calc);

        Operation operation = new Operation(add, substract, multiply, divide);

        operation.addition(3, 5);
        operation.substraction(54, 33);
        operation.multiplication(5, 5);
        operation.division(9, 5);
    }
}
