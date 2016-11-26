/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

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
public class CircleTest {
    
    public CircleTest() {
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
     * Test of getArea method, of class Circle.
     */
    @Test
    public void testGetArea() {
        System.out.println("Circle.getArea(100)");
        Circle instance = new Circle(100);
        double expResult = ( Math.PI * 100 * 100 );
        double result = instance.getArea();
        assertEquals(expResult, result, 0.0);
        System.out.println(instance.getDescr());        
    }
    @Test
    public void testGetArea2() {
        System.out.println("Circle.getArea(0)");
        Circle instance = new Circle(0);
        double expResult = 0;
        double result = instance.getArea();
        assertEquals(expResult, result, 0.0);
        System.out.println(instance.getDescr());        
    }

    
}
