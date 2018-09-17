package homework4.massive;

import java.util.Random;

/**
 * Created by Алексей on 16.09.2018.
 */
public class SearchMinMaxValue {
    public static void start() {

        int[] arrayOfMaxMinValue = new int[20];

        fillAnArrayWithRandomValues(arrayOfMaxMinValue);
        findAndReplaceMinMaxValueOfArray(arrayOfMaxMinValue);
    }

    public static void fillAnArrayWithRandomValues (int[] array) {
        Random random = new Random();
        int symbolOfArrayValue;
        int randomValue;
        for (int i = 0; i < array.length; i++) {
            symbolOfArrayValue = random.nextInt(2);
            randomValue  = random.nextInt(11);
            if (symbolOfArrayValue == 0) {
                array[i] = (-1 * randomValue);
            }
            if (symbolOfArrayValue == 1) {
                array[i] = randomValue;
            }
            //System.out.println("value of array " + i + " = " + array[i]);
        }

    }

    private static void findAndReplaceMinMaxValueOfArray(int[] array) {
        int minPositiveValue = 10, maxNegativeValue = -1;
        int elementWithMinPositiveValue = 0, elementWithMaxNegativeValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 1 && array[i] <= 10) {
                if (array[i] < minPositiveValue) {
                    minPositiveValue = array[i];
                    elementWithMinPositiveValue = i;
                }
            }
            if (array[i] >= -10 && array[i] <=-1) {
                if (array[i] < maxNegativeValue) {
                    maxNegativeValue = array[i];
                    elementWithMaxNegativeValue = i;
                }
            }
        }
        System.out.println("min positive value = "+minPositiveValue+" in element of array "+elementWithMinPositiveValue);
        System.out.println("max negative value = "+maxNegativeValue+" in element of array "+elementWithMaxNegativeValue);
        array[elementWithMinPositiveValue] = maxNegativeValue;
        array[elementWithMaxNegativeValue] = minPositiveValue;
        System.out.println("After replace");
        System.out.println("value in "+elementWithMinPositiveValue+" element of array = "+array[elementWithMinPositiveValue]);
        System.out.println("value in "+elementWithMaxNegativeValue+" element of array = "+array[elementWithMaxNegativeValue]);
    }
}
