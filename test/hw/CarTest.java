/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

//import old.Car;
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
     * Test of refuel method, of class Car.
     */
    @Test
    public void testRefuel() { //+testGetGasVolume
        System.out.println("refuel");
        int volume = 10;
        Car car = new Car();
        car.refuel(volume);
        assertEquals(volume, car.getGasVolume());
       
        int volume2 = 0;
        Car car2 = new Car();
        car2.refuel(volume2);
        assertEquals(volume2, car2.getGasVolume());

    }


    /**
     * Test of getCarModel method, of class Car.
     */
    @Test
    public void testGetSetCarModel() {
        System.out.println("getCarModel");
        // Test 1 - Null
        Car instance = new Car();
        String expResult = null;
        String result = instance.getCarModel();
        assertEquals(expResult, result);
        // Test2 - Name
        expResult = "Audi Q7";
        instance.setCarModel(expResult);
        result = instance.getCarModel();
        assertEquals(expResult, result);        
    }



    /**
     * Test of changeTire method, of class Car.
     */
    @Test
    public void testChangeTire() {
        System.out.println("changeTire");
        Integer nr = 3;
        Car instance = new Car();
        Integer tireChanged = instance.changeTire(nr);
        assertEquals(nr, tireChanged);

        nr = 5;
        tireChanged = instance.changeTire(nr);
        assertEquals(0, (int)tireChanged);
        
        nr = 0;
        tireChanged = instance.changeTire(nr);
        assertEquals(nr, tireChanged);
        
        nr = -1;
        tireChanged = instance.changeTire(nr);
        assertEquals(0, tireChanged.intValue());

        nr = null;
        tireChanged = instance.changeTire(nr);
        assertEquals(0, tireChanged.intValue());

    }

    /**
     * Test of drive method, of class Car.
     */
    @Test
    public void testDrive() {
        System.out.println("Car::drive");
        Car newCar = new Car();
        Car myCar = newCar;
            myCar = newCar; // Test for duplicate buildAcar constr        
        myCar.drive();
        
        myCar.setCarModel("Audi Q7");
        myCar.refuel(20);
        myCar.refuel(5);
        assertEquals(25, myCar.getGasVolume());
        myCar.drive();
        assertEquals(myCar.state, "Driving");
        myCar.changeTire(1); 
        myCar.drive();
        assertEquals(myCar.state, "Driving");
        myCar.stop();
        assertEquals(myCar.state, "Stopped");
        
        System.out.println("***************");
        myCar.refuel(5);
        myCar.drive();
        System.out.println(myCar.state);
        
    }
    
}
