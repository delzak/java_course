package PatternCommand;

/**
 * Created by Алексей on 25.11.2018.
 */
public class SubstractCommand implements Command{
    private Calc theCalc;

    public SubstractCommand(Calc calc){
        this.theCalc = calc;
    }

    public void execute(){
        theCalc.substract();
    }
}
