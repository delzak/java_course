package ru.stqa.pft.homework;

public class Main {

    public static void main(String[] args)    {

        Point p1 = new Point(20, 20);
        Point p2 = new Point(40, 40);
        CalculateDistance d = new CalculateDistance();
        System.out.println("Расстояние между двумя точками = " + d.distance(p1, p2));
    }

}
