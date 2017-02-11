package ru.stqa.pft.homework;

public class Main {

    public static void main(String[] args)    {

        Point p1 = new Point(20, 20);
        Point p2 = new Point(40, 40);
        CalculateDistance d = new CalculateDistance();
        System.out.println("Точка 1 имеет координаты x = " + p1.x + " и y = " + p1.y + "\n" +
                           "Точка 2 имеет координаты x = " + p2.x + " и y = " + p2.y + "\n" +
                           "Расстояние между двумя точками = " + d.distance(p1, p2));
    }

}
