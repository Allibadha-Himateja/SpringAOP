package com.iss.springaop.Service;
import com.iss.springaop.Models.*;

public class Shape {
    private Triangle triangle;
    private Circle circle;
    public Triangle getTriangle() {
        return triangle;
    }
    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
    public Circle getCircle() {
        return circle;
    }
    public void setCircle(Circle circle) {
        this.circle = circle;
    }
    public void callingShape()
    {
        System.out.println("callingShape");
    }
}
