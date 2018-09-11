import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 10.09.2018.
 */
public class Base {
    public static void main (String[] args) throws IOException {
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

        Operation operation = new Operation();
        operation.operation(a, b, c);
    }
}
