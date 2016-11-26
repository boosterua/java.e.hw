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
 * @author p
 */
public class VehicleTest {
    
    public VehicleTest() {
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
     * Test of changeTire method, of class Vehicle.
     */
    @Test
    public void testChangeTire() {
        System.out.println("changeTire");
        int ww = 0;
        Vehicle instance = new VehicleImpl();
        instance.changeTire(ww);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drive method, of class Vehicle.
     */
    @Test
    public void testDrive() {
        System.out.println("drive");
        Vehicle instance = new VehicleImpl();
        instance.drive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VehicleImpl extends Vehicle {
    }
    
}
