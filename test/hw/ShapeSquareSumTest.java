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
        Shape all_shapes = new ShapeSquareSum(r1, r2, tr, tz);

        double expResult = 66624.67;
        double result = all_shapes.getArea();
        assertEquals(expResult, result, 0.001);
        System.out.println(all_shapes.getDescr());

//        for (Shape k: new Shape[]{r1,r2,tr,tz})
//            System.out.println(k.getDescr());        
        

    }

    
}
