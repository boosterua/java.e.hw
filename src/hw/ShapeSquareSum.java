package hw;

public class ShapeSquareSum extends Shape{
    private String elements=""; // Description of each elem with its sizes and params
    private Shape[] shapes;

    ShapeSquareSum(Shape ... shapes){
        this.shapes = shapes;
    }
    
    public double sumArea(){
        double area = 0;
        for (Shape s:shapes){
            area += s.getArea();
            elements += s.getDescr()+"; ";
        }
        return area;
    }
    
    @Override
    public double getArea(){ return sumArea();}

    @Override
    public String getDescr(){
        return elements;
    }
}

    abstract class Shape {
        public double area = 0;
        public String name = "";
        //public abstract double sumArea(Shape... shapes);
        public abstract double getArea();
        public abstract String getDescr();
    }
    
    class Trapezium extends Shape{
        double a,b,h;
        Trapezium(double top, double bottom, double height){
            this.a = top; // topside
            this.b = bottom; // bottom side
            this.h = height; // height
        };
        
        @Override
        public String getDescr(){
            return String.format("Trapezium(%.2f,%.2f,%.2f)=%.2f", a, b, h, area);
        }
        
        @Override
        public double getArea(){
            area = ( a + b ) / 2 * h ; 
            return area;
        }
    }

    class Circle extends Shape {
        double radius = 0;
        Circle (double r){
            radius = r;    // System.out.println("New Circle radius=" + r );
        }
        
        @Override
        public double getArea(){
            // System.out.println("getSq in Circle. R=" + radius);
            area =  radius * radius  *  Math.PI;
            return (double) area;
        }
        
        @Override
        public String getDescr(){
            return String.format("Circle(%.2f)=%.2f", radius, area);

        }     
    }

    class Triangle extends Shape {
        double s1, s2, s3;
        Triangle (double s1, double s2, double s3){
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public double getArea(){
            double sp = (s1 + s2 + s3) / 2; //semiperimeter 
            area = (double) Math.sqrt( sp * (sp-s1) * (sp-s2) * (sp-s3) );
            return area;            
        }
        
        @Override
        public String getDescr(){  return String.format("Triangle(%.2f,%.2f,%.2f)=%.2f", s1,s2,s3, area);}     
    }
