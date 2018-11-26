package PatternCommand;

/**
 * Created by Алексей on 25.11.2018.
 */
public class MultiplyCommand implements Command{
    private Calc theCalc;

    public MultiplyCommand(Calc calc){
        this.theCalc = calc;
    }

    public void execute(){
        theCalc.multiply();
    }
}
