package com.tree.www.test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by pysh on 2017/10/27.
 */
public class Shapes {
    public static void main(String[] args) {
        Vector<Shape> s = new Vector<>();
        s.add(new Circle());
        s.add(new Square());
        s.add(new Triangle());
        for (Shape shape : s) {
            shape.draw();
        }

    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw(){
        System.out.println("Circle.draw()");
    }
}

class Square implements Shape {
    public void draw(){
        System.out.println("Square.draw()");
    }
}

class Triangle implements Shape {
    public void draw(){
        System.out.println("Triangle.draw()");
    }
}
