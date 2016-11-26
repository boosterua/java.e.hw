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
public class CarTest {
    
    public CarTest() {
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
     * Test of BuildACar method, of class Car.
     */
    @Test
    public void testBuildACar() {
        System.out.println("BuildACar");
        Car instance = new Car();
        Car expResult = null;
        Car result = instance.BuildACar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refuel method, of class Car.
     */
    @Test
    public void testRefuel() {
        System.out.println("refuel");
        int volume = 0;
        Car instance = new Car();
        instance.refuel(volume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCarModel method, of class Car.
     */
    @Test
    public void testSetCarModel() {
        System.out.println("setCarModel");
        String model = "";
        Car instance = new Car();
        instance.setCarModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarModel method, of class Car.
     */
    @Test
    public void testGetCarModel() {
        System.out.println("getCarModel");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getCarModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGasVolume method, of class Car.
     */
    @Test
    public void testGetGasVolume() {
        System.out.println("getGasVolume");
        Car instance = new Car();
        int expResult = 0;
        int result = instance.getGasVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGasVolume method, of class Car.
     */
    @Test
    public void testSetGasVolume() {
        System.out.println("setGasVolume");
        int delta = 0;
        Car instance = new Car();
        instance.setGasVolume(delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeTire method, of class Car.
     */
    @Test
    public void testChangeTire() {
        System.out.println("changeTire");
        int nr = 0;
        Car instance = new Car();
        instance.changeTire(nr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drive method, of class Car.
     */
    @Test
    public void testDrive() {
        System.out.println("drive");
        Car instance = new Car();
        instance.drive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
