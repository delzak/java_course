package homework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 11.09.2018.
 */
public class Calculator {
    public static void startCalculator () throws IOException {
        double a; //first number
        double b; //second number
        int c; //operation
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input the first number:");
        a = Double.parseDouble(reader.readLine());

        System.out.println("Input the second number:");
        b = Double.parseDouble(reader.readLine());

        System.out.println("Input the number of operation:");
        System.out.println("1: +\n2: -\n3: *\n4: /");
        c = Integer.parseInt(reader.readLine());

        operation(a, b, c);
    }


    public static void operation (double a, double b, int c) {
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

        System.out.printf(" = %.4f", a);
    }

}
