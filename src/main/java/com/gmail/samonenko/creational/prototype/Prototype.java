package com.gmail.samonenko.creational.prototype;

/**
 * Motivation: to clone already exist object(deep copy)
 */

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line(new Point(start.x, start.y), new Point(end.x, end.y));
    }

    @Override
    public java.lang.String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Prototype {

    public static void main(String[] args) {
        Line line1 = new Line(new Point(1, 6), new Point(2, 15));
        Line line2 = line1.deepCopy();
        line2.start.x = 33;

        System.out.println(line1);
        System.out.println(line2);
    }

}
