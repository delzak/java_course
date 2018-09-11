/**
 * Created by Алексей on 11.09.2018.
 */
public class Operation {
    public void operation (double a, double b, int c) {
        /*в зависимости от выбранного действия через
        свитч будет выполнена операция с числами
         */
        switch (c) {
            case 1:
                System.out.print(a + " + " + b);
                a = a+b;
                break;
            case 2:
                System.out.print(a + " - " + b);
                a = a-b;
                break;
            case 3:
                System.out.print(a + " * " + b);
                a = a*b;
                break;
            case 4:
                System.out.print(a + " / " + b);
                a = a/b;
                break;
        }

        //System.out.println(" = " + a);
        System.out.printf(" = %.4f", a);
    }

}
