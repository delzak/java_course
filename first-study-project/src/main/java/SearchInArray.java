import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 13.09.2018.
 */
public class SearchInArray {
    public static void startSearch() throws IOException {
        String word = null;
        int arrayLength = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of words");
        int amount = Integer.parseInt(reader.readLine());
        String[] array = new String[amount];

        System.out.println("Enter the word");
        for (int i = 0; i < amount; i++) {
            array[i] = reader.readLine();
        }

        for (int i = 0; i < amount; i++) {
            int nowLength = array[i].length();
            if (nowLength > arrayLength) {
                arrayLength = nowLength;
                word = array[i];
            }
        }
        System.out.println("The maximum length of an array element is " + word + " (length = " + arrayLength + ")");
    }
}
