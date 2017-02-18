package ru.stqa.pft.homework.lesson2;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.lesson1.Point;

/**
 * Created by Алексей on 18.02.2017.
 */
public class PointTests {

    @Test
    public void testDistanceNotZero(){
        Point p1 = new Point(13, 25);
        Point p2 = new Point(44, 1);
        assert p1.distance(p2) != 0;
    }

    @Test
    public void testDistance(){
        Point p1 = new Point(20, 20);
        Point p2 = new Point(40, 40);
        assert p1.distance(p2) >= 25;
    }

    @Test
    public void testWrong(){
        Point p1 = new Point(20, 20);
        Point p2 = new Point(40, 40);
        assert p1.distance(p2) < 0;
    }
    @Test
    public void testObject(){
        Point p1 = new Point(20, 20);
        Point p2 = new Point(40, 40);
        Assert.assertSame(p1, p1);
        Assert.assertNotSame(p2, p1);
    }
    @Test
    public void testNotNull(){
        Point p1 = new Point(20, 20);
        Point p2 = new Point(40, 40);
        Assert.assertNotNull(p1);
        Assert.assertNotNull(p2);
    }
}
