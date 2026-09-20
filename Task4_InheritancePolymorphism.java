/**
 * Task 4: Inheritance & Polymorphism Practice
 * ----------------------------------------------
 * Demonstrates a small class hierarchy (Shape -> Circle, Square, Triangle)
 * using inheritance, and demonstrates runtime polymorphism through
 * method overriding of area() and display().
 */
public class Task4_InheritancePolymorphism {

    // ----- Base (parent) class -----
    // Shape defines the common structure that every specific shape will inherit.
    static class Shape {
        String name = "Shape";

        // Method to be overridden by each subclass (polymorphism)
        double area() {
            return 0.0;
        }

        // Common display method; subclasses override it to add their own details
        void display() {
            System.out.println(name + " -> Area: " + area());
        }
    }

    // ----- Derived class: Circle -----
    static class Circle extends Shape {
        double radius;

        Circle(double radius) {
            this.radius = radius;
            this.name = "Circle";
        }

        // Overriding area() for circle-specific formula: pi * r^2
        @Override
        double area() {
            return Math.PI * radius * radius;
        }

        // Overriding display() to show shape-specific info before calling parent logic
        @Override
        void display() {
            System.out.printf("%s (radius = %.2f) -> Area: %.2f%n", name, radius, area());
        }
    }

    // ----- Derived class: Square -----
    static class Square extends Shape {
        double side;

        Square(double side) {
            this.side = side;
            this.name = "Square";
        }

        // Overriding area() for square-specific formula: side^2
        @Override
        double area() {
            return side * side;
        }

        @Override
        void display() {
            System.out.printf("%s (side = %.2f) -> Area: %.2f%n", name, side, area());
        }
    }

    // ----- Derived class: Triangle -----
    static class Triangle extends Shape {
        double base, height;

        Triangle(double base, double height) {
            this.base = base;
            this.height = height;
            this.name = "Triangle";
        }

        // Overriding area() for triangle-specific formula: 0.5 * base * height
        @Override
        double area() {
            return 0.5 * base * height;
        }

        @Override
        void display() {
            System.out.printf("%s (base = %.2f, height = %.2f) -> Area: %.2f%n",
                    name, base, height, area());
        }
    }

    public static void main(String[] args) {
        // Creating an array of Shape references pointing to different subclass
        // objects. This is the core of runtime polymorphism: the same
        // reference type (Shape) can hold objects of different subclasses,
        // and the correct overridden method is chosen automatically at runtime.
        Shape[] shapes = {
                new Circle(5),
                new Square(4),
                new Triangle(6, 3)
        };

        System.out.println("===== Shape Hierarchy: Inheritance & Polymorphism =====\n");

        // Even though each element is typed as "Shape", calling display()
        // executes the version defined in that object's actual subclass.
        for (Shape s : shapes) {
            s.display();
        }

        // Demonstrating that total area calculation works generically,
        // without needing to know which specific shape it is.
        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.area();
        }
        System.out.printf("%nTotal combined area of all shapes: %.2f%n", totalArea);
    }
}
