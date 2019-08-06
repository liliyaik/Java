package ru.stqa.lil.sandbox;

public class Point {

  double p1;
  double p2;

  public Point (double p1, double p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public double distance(Point p) {
    double sqrt = (double) Math.sqrt(((this.p1 - p.p1) * (this.p1 - p.p1)) + ((this.p2 - p.p2) * (this.p2 - p.p2)));
    return sqrt;
    }
  }


