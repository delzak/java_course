package PatternCommand;

/**
 * Created by Алексей on 25.11.2018.
 */
public class AddCommand implements Command{
    private Calc theCalc;

    public AddCommand(Calc calc){
        this.theCalc = calc;
    }

    public void execute(){
        theCalc.add();
    }
}
