package hw;

import old.HW;

public class Task06 extends HW  {
    /*
         * Задание 6.
         * Допустимыми фигурами являются круг Circle, треугольник Triangle, 
         * параллелограмм Parallelogram и трапеция Trapezium. В классе допустимых фигур Shape
         * определить операцию сложения, если суммой фигур служит сумма их площадей.
         */
/*
    Task06(int task_nr){
        print_header(task_nr, "Shape Square Sum");
        
        Circle r1 = new Circle(100);
        Circle r2 = new Circle(90);
        Triangle tr = new Triangle(100,200,150);
        Trapezium tz = new Trapezium(200,300,10);
        Shape all_shapes = new ShapesArea();
        System.out.printf("Total area: %.2f \n\tFor Figures: %s\n",
                            all_shapes.sumArea(r1, r2, tr, tz),
                            all_shapes.getDescr()
                         );
    }
}

    abstract class Shape {
        public double area = 0;
        public String name = "";
        public double sumArea(Shape... shapes){ return 0;}       
        public double getArea(){ return 0;}
        public String getDescr(){return "";}        
    }


    class ShapesArea extends Shape{
        public String elements = "";
        
        public double sumArea(Shape... shapes){
            double area = 0;
              for (Shape s:shapes){
                  area += s.getArea();
                  elements += s.getDescr()+"; ";
              }
            return area;
        }    
        
        public String getDescr(){
            return elements;
        }
    }
    

    class Trapezium extends Shape{
        double a,b,h;
        Trapezium(double top, double bottom, double height){
            this.a = top; // topside
            this.b = bottom; // bottom side
            this.h = height; // height
        };
        
        public String getDescr(){
            return String.format("Trapezium(%.2f,%.2f,%.2f)=%.2f", a, b, h, area);
        }
        
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
        
        public double getArea(){
            // System.out.println("getSq in Circle. R=" + radius);
            area =  radius * radius  *  Math.PI;
            return (double) area;
        }
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

        public double getArea(){
            double sp =     
                    (s1 + s2 + s3) / 2; //semiperimeter 
            area = (double) Math.sqrt( sp * (sp-s1) * (sp-s2) * (sp-s3) );
            return area;            
        }
        public String getDescr(){  return String.format("Triangle(%.2f,%.2f,%.2f)=%.2f", s1,s2,s3, area);}     
    }
*/
    
}