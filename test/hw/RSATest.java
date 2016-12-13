/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hw.RSA;
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
public class RSATest {
    
    public RSATest() {
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
     * Test of splitEqually method, of class Task05.
     */
    @Test
    public void testSplitEqually() {
        System.out.println("splitEqually");
        String text = "1234567890ABC";
        int size = 4;
        List<String> expResult = new ArrayList<String>(Arrays.asList("1234","5678","90AB","C"));
        List<String> result = RSA.splitEqually(text,size);
        assertEquals(expResult, result);
    }

    @Test
    public void testSplitEqually2() {
        System.out.println("splitEqually");
        String text = "";
        int size = 4;
        List<String> expResult = new ArrayList<String>(Arrays.asList(""));
        List<String> result = RSA.splitEqually(text,size);
        assertEquals(expResult.toString(), result.toString());
    }    

    @Test
    public void testSplitEqually3() {
        System.out.println("splitEqually");
        String text = "321";
        int size = 4;
        List<String> expResult = new ArrayList<String>(Arrays.asList("321"));
        List<String> result = RSA.splitEqually(text,size);
        assertEquals(expResult.toString(), result.toString());
    }    
    
    /**
     * Test of encrypt method, of class RSA.
     */
    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String message = "Message";
        RSA instance = new RSA();
        List<BigInteger> result = instance.encrypt(message);
        String msgDecrypted = instance.decrypt(result);
        assertEquals(msgDecrypted, message);
        
        // TEST 2
        message = ("Oh, say! can you see by the dawn's early light \n" +
            "What so proudly we hailed at the twilight's last gleaming; \n" +
            "Whose broad stripes and bright stars, through the perilous fight, \n" +
            "O'er the ramparts we watched were so gallantly streaming? \n" +
            "And the rocket's red glare, the bombs bursting in air, \n" +
            "Gave proof through the night that our flag was still there: \n" +
            "Oh, say! does that star-spangled banner yet wave \n" +
            "O'er the land of the free and the home of the brave?");        
        result = instance.encrypt(message);
        msgDecrypted = instance.decrypt(result);
        assertEquals(msgDecrypted, message);
        //assertFalse(msgDecrypted == message);        
    }

    /**
     * Test of printKeys method, of class RSA.
     */
    @Test
    public void testPrintKeys() {
        System.out.println("printKeys");
        RSA instance = new RSA();
        instance.printKeys();
    }

    /**
     * Test of generateKeys method, of class RSA.
     */
/*
    @Test
    public void testGenerateKeys() {
        System.out.println("generateKeys");
        RSA instance = new RSA();
        KeySet expResult = null;
        KeySet result = instance.generateKeys();
        assertEquals(expResult, result);
    }
*/
    
}
