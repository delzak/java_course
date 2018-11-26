package PatternCommand;

/**
 * Created by Алексей on 25.11.2018.
 */
public class DivideCommand implements Command{
    private Calc theCalc;

    public DivideCommand(Calc calc){
        this.theCalc = calc;
    }

    public void execute(){
        theCalc.divide();
    }
}
