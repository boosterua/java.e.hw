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
public class TrapeziumTest {
    
    public TrapeziumTest() {
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
     * Test of getDescr method, of class Trapezium.
     */
    @Test
    public void testGetDescr() {
        System.out.println("getDescr");
        Trapezium instance = new Trapezium(20,30,40);
        Double expResult = 1000d;
        Double result = instance.getArea();
        assertEquals(expResult, result, 1e-10);
   
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
       
    }
    
}
