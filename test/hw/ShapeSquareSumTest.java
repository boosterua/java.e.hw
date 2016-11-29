/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tonchief <ton.chief at tonchief.com>
 */
public class ShapeSquareSumTest {
    
    public ShapeSquareSumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sumArea method, of class ShapeSquareSum.
     */
    @Test
    public void testSumArea() {
        //Circle(100.00)=31415.93; Circle(90.00)=25446.90; Triangle(100.00,200.00,150.00)=7261.84; Trapezium(200.00,300.00,10.00)=2500.00; 
        System.out.println("sumArea");
        Shape[] shapes = null;
        Circle r1 = new Circle(100);
        Circle r2 = new Circle(90);
        Triangle tr = new Triangle(100,200,150);
        Trapezium tz = new Trapezium(200,300,10);

        double expResult = 66624.67;
        double result = Shape.sumArea(r1, r2, tr, tz);
        assertEquals(expResult, result, 0.001);

        for (Shape k: new Shape[]{r1,r2,tr,tz})
            System.out.println(k.getDescr());        
        
        //      as an example, Test trapezium for boudary values (null obj, 0 sides, negative values);
        tz = new Trapezium(0,0,0);
        expResult = 0;
        result = Shape.sumArea(tz);
        assertEquals(expResult, result, 0.001);

        tz = null;
        expResult = 0;
        result = Shape.sumArea(tz);
        assertEquals(expResult, result, 0.001);

        tz = new Trapezium(-200,-300,-10);
        expResult = 2500;
        result = Shape.sumArea(tz);
        assertEquals(expResult, result, 0.001);        

    }
    


    /**
     * Test of getArea method, of class Trapezium.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Trapezium instance = new Trapezium(20, 30, 0);
        Double expResult = 0d;
        Double result = instance.getArea();
        assertEquals(expResult, result, 1e-10);
   
        instance = new Trapezium(20,30,40);
        expResult = 1000d;
        result = instance.getArea();
        assertEquals(expResult, result, 1e-10);
        
        System.out.println("getDescr");
        String descr = instance.getDescr();
        System.out.println(descr);
        assertEquals("Trapezium(20.00,30.00,40.00)=1000.00", descr);
          
           
       
    }

    
}
