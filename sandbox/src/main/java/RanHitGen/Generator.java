package RanHitGen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {

    public static void main (String[] args) throws IOException {

        List<String> hits = Arrays.asList("Вертикальный", "Правая диагональ", "Левая диагональ", "Правый горизонт",
                "Левый горизонт", "Правая нижняя диагональ", "Левая нижняя диагональ", "Правая плоскость", "Левая плоскость");
        int hit;
        int lastHit = 15;
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите количество ударов: ");
        int numberOfHits = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < numberOfHits; i++) {
            hit = random.nextInt(8);
            while (hit == lastHit) {
                hit = random.nextInt(8);
            }
            System.out.println((i + 1) + ". " + hits.get(hit));
            lastHit = hit;
        }
        //System.out.println(numberOfHits + 1 + ". Сильный удар");
    }
}
