package com.shouvit.assignments.assignment12;

class Circle {
    double radius;
    String color;

    Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    Circle(double radius) {
        this.radius = radius;
    }

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ",color=" + color + ']';
    }
}

class Cylinder extends Circle {
    double height;

    Cylinder() {
        this.height = 1.0;
    }

    Cylinder(double radius) {
        super(radius);
    }

    Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.height * super.getArea();
    }
}

public class Main {
    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for(Circle c : circles) {
            System.out.println(c.toString() + "\n Area: " + c.getArea() + "\n Volume: " + ((Cylinder)c).getVolume());
        }
    }
}
