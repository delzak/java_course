import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 10.09.2018.
 */
public class Base {
    public static void main (String[] args) throws IOException {
        int choice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of the program you want to start:");
        System.out.println("1. Calculator\n2. Search the max element of an array");
        choice = Integer.parseInt(reader.readLine());

        switch (choice) {
            case 1:
                Calculator.startCalculator();
                break;
            case 2:
                SearchInArray.startSearch();
                break;
        }

    }
}
