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
        Car car = new Car().BuildACar();
        car.refuel(volume);
        assertEquals(car.getGasVolume(),volume);
       
        int volume2 = 0;
        Car car2 = new Car().BuildACar();
        car2.refuel(volume2);
        assertEquals(car2.getGasVolume(),volume2);

    }


    /**
     * Test of getCarModel method, of class Car.
     */
    @Test
    public void testGetSetCarModel() {
        System.out.println("getCarModel");
        // Test 1 - Null
        Car instance = new Car().BuildACar();
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
        Car instance = new Car().BuildACar();
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
        Car myCar = newCar.BuildACar();
            myCar = newCar.BuildACar(); // Test for duplicate buildAcar constr        
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
        
    }
    
}
