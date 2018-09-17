import homework3.Calculator;
import homework3.SearchMaxElementInArray;
import homework4.gift.GiftCollection;
import homework4.massive.SearchMinMaxValue;

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
        System.out.println("1. Calculator\n2. Search the max element of an array\n" +
                "3. Search and replace the min and max values in an array\n4. Collect a New Year's gift");
        choice = Integer.parseInt(reader.readLine());

        switch (choice) {
            case 1:
                Calculator.startCalculator();
                break;
            case 2:
                SearchMaxElementInArray.startSearch();
                break;
            case 3:
                SearchMinMaxValue.start();
                break;
            case 4:
                GiftCollection.collect();
                break;
        }

    }
}
