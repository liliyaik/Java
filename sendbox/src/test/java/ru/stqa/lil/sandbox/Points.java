package ru.stqa.lil.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Points {

  @Test
  public void test1(){

    Point p1 = new Point (1, 11);
    Point p2 = new Point (20, 30);

    System.out.println("расстояние между точками "+p1+" и "+p2+" равно "+p1.distance(p2));
    Assert.assertEquals(p1.distance(p2), 26.870057685088806);
  }

}
