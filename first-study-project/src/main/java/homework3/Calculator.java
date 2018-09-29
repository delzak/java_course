package homework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 11.09.2018.
 */
public class Calculator {
    public static void startCalculator () throws IOException {
        double a = 0; //first number
        double b = 0; //second number
        int c = 0; //operation
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (a == 0) {
            try {
                System.out.println("Введите первое число:");
                a = Double.parseDouble(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Число указано неверно! " + e.getMessage());
                a = 0;
            }
        }

        while (b == 0) {
            try {
                System.out.println("Введите второе число:");
                b = Double.parseDouble(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Число указано неверно! " + e.getMessage());
                b = 0;
            }
        }

        while (c == 0) {
            try {
                System.out.println("Укажите номер действия:");
                System.out.println("1: +\n2: -\n3: *\n4: /");
                c = Integer.parseInt(reader.readLine());
                if (c < 1 || c > 4) {
                    System.out.println("Нет такого действия!");
                    c = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Номер действия указан неверно! " + e.getMessage());
                c = 0;
            }
        }

        operation(a, b, c);
        reader.close();
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
