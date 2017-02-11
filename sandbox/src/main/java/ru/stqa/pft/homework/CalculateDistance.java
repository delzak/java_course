package ru.stqa.pft.homework;

public class CalculateDistance {

    public double distance(Point p1, Point p2) {

        double a = Math.sqrt( (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
        return a;
    }
}
