package hw;

    abstract class Shape {

        public double area = 0;
        public String name = "";
        private static String elements=""; // Description of each elem with its sizes and params
        private Shape[] shapes;        
        public abstract double getArea();
        
        public Shape(Shape ... shapes) {
            this.shapes = shapes;
        }

        public Shape() {
        }

        public String getDescr(){
            return elements;
        }

        public static double sumArea(Shape ... shapes){
            double area = 0;
            if (shapes==null || shapes.length==0) return 0;
            for (Shape s:shapes){
                if(s==null) continue;
                area += s.getArea();
                elements += s.getDescr()+"; ";
            }
            return area;
        }
    }

    class Trapezium extends Shape{
        double a,b,h;
        Trapezium(double top, double bottom, double height){
            this.a = Math.abs(top); // topside
            this.b = Math.abs(bottom); // bottom side
            this.h = Math.abs(height); // height
        };
        
        @Override
        public String getDescr(){
            return String.format("Trapezium(%.2f,%.2f,%.2f)=%.2f", a, b, h, area);
        }
        
        @Override
        public double getArea(){ // Lazy calc
            area = ( a + b ) / 2 * h ; 
            return area;
        }
    }

    class Circle extends Shape {
        double radius = 0;
        Circle (double r){
            radius = Math.abs(r);
        }
        
        @Override
        public double getArea(){
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
            this.s1 = Math.abs(s1);
            this.s2 = Math.abs(s2);
            this.s3 = Math.abs(s3);
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
