package homework6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Алексей on 25.09.2018.
 */
public class StaticTextStatistics {
    public static void start() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/homework6/WordsFile.txt"));
        List<String> words = new ArrayList<String>();
        Map<String, Integer> statistics = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            words.add(word);
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
        }

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("После сортировки элементы коллекции идут в следующем порядке:");
        for (String s : words) {
            System.out.print(s + " ");
        }

        System.out.println("\n" + statistics);

        int repeat = 0;
        int maxRepeats = 0;
        int elementOfArrayWithMaxRepeat = 0;
        for (int i = 0; i < words.size(); i++) {
            repeat = 0;
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    repeat++;
                    System.out.println("слово " + words.get(i) + " повторяется " + repeat + " раз");
                }
                if (maxRepeats < repeat) {
                    maxRepeats = repeat;
                    elementOfArrayWithMaxRepeat = i;
                }
            }

        }
        System.out.println("Слово " + "\"" +words.get(elementOfArrayWithMaxRepeat) + "\"" +
                " встречается максимальное число раз - " + maxRepeats);
    }
}
