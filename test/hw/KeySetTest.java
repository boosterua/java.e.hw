/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.math.BigInteger;
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
public class KeySetTest {
    
    public KeySetTest() {
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
     * Test of getPrivateKey method, of class KeySet.
     */
    @Test
    public void testGetPrivateKey() {
        System.out.println("getPrivateKey");
        KeySet instance = null;
        BigInteger[] expResult = null;
        BigInteger[] result = instance.getPrivateKey();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPPublicKey method, of class KeySet.
     */
    @Test
    public void testGetPPublicKey() {
        System.out.println("getPPublicKey");
        KeySet instance = null;
        BigInteger[] expResult = null;
        BigInteger[] result = instance.getPPublicKey();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
