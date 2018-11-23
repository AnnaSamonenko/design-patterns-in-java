package com.gmail.samonenko.structural.adapter;

class Square {
    public int side;

    public Square(int side) {
        this.side = side;
    }
}

interface Rectangle {
    int getWidth();

    int getHeight();

    default int getArea() {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle {

    private Square square;

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.side;
    }

    @Override
    public int getHeight() {
        return square.side;
    }
}

/**
 * Motivation: convert class of one interface to another
 */
public class Adapter {

    public static void main(String[] args) {
        Square square = new Square(5);

        Rectangle convert = new SquareToRectangleAdapter(square);
        System.out.println(convert.getArea());
    }
}
