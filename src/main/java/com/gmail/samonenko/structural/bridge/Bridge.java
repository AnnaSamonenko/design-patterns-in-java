package com.gmail.samonenko.structural.bridge;


interface Renderer {

    String whatToRenderAs();

}

class RasterRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return null;
    }
}

class VectorRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return null;
    }
}

abstract class Shape {

    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();
}

class Triangle extends Shape {

    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return renderer.whatToRenderAs();
    }
}

class Square extends Shape {

    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return renderer.whatToRenderAs();
    }
}


/**
 * Motivation: Used to decouple an abstraction from it's implementation.
 * In order to escape of Cartesian product duplication.
 */

public class Bridge {

    public static void main(String[] args) {

    }

}


