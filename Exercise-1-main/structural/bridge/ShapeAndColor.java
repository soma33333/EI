package structural.bridge;

interface Color {
    void applyColor();
}

class RedColor implements Color {
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class BlueColor implements Color {
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing a circle. ");
        color.applyColor();
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing a rectangle. ");
        color.applyColor();
    }
}

public class ShapeAndColor {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        Shape blueRectangle = new Rectangle(new BlueColor());

        redCircle.draw();
        blueRectangle.draw();
    }
}
