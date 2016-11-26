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
public class ShapeTest {
    
    public ShapeTest() {
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
     * Test of getArea method, of class Shape.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Shape instance = new ShapeImpl();
        double expResult = 0.0;
        double result = instance.getArea();
        assertEquals(expResult, result, 0.0);
    }


    public class ShapeImpl extends Shape {

        public double getArea() {
            return 0.0;
        }

        public String getDescr() {
            return "";
        }
    }
    
}
