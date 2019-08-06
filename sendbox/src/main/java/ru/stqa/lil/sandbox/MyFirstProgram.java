package ru.stqa.lil.sandbox;

public class MyFirstProgram {

  public static void main(String[] args)
  {
    System.out.println("Hello? world!");

    Point p1 = new Point (1, 11);
    Point p2 = new Point (20, 30);

    System.out.println(p1);
    System.out.println(p2);
    System.out.println("расстояние между точками "+p1+" и "+p2+" равно "+p1.distance(p2));
  }
}