package dec08c;

/**
 * @author F. Ulstack
 * 
 * create Shape, Triangle, Circle
 */

interface Shape
{
    double perimeter();    
}

class Rectangle implements Shape
{
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter()
    {
        return 2.0*(width + height);        
    }
}

class Circle implements Shape
{
    private int radius;

    public Circle(int radius)
    {
        this.radius = radius;
    }
    
    @Override
    public double perimeter()
    {
        return 2*Math.PI*radius;
    }
}

class Triangle implements Shape
{
    private int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c ;
    }
    
}


public class Dec08C {

    public static void main(String[] args) {
        
        Shape[] arr = {new Triangle(1, 2, 3), new Circle(2), new Rectangle(2, 4)};
        
        for (Shape shape : arr) {
            System.out.println("I am a " + shape.getClass());
            System.out.println("my perimiter is " + shape.perimeter());
        }
        
    }
    
}
