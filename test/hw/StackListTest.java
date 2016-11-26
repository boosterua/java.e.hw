package hw;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StackListTest {
    
    public StackListTest() {
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

    
    public StackList fillArray(){
        StackList A = new StackList();
        A.push(111111, "Guy First");
        A.push(123456, "Emma Jackson");
        A.push(134321, "Peter Ackwell");
        A.push(111333, "Gregory Wentworth");
        A.push(100100, "Gary Eaton");
        A.push(222222, "Guy Last");
        return A;
    }
    
    /**
     * Test of push method, of class StackList.
     */
    @Test
    public void testPush() {
        System.out.println("push");

        long emId = 0;
        String emName = null;
        StackList instance = new StackList();
        instance.push(emId, emName);
        assertEquals(instance.first.emId == emId, instance.first.emName == emName);
        
        emId = 123456;
        emName = "Guy Twentieth";
        instance.push(emId, emName);
        assertEquals(instance.first.emId == emId, instance.first.emName == emName);        
    }

    /**
     * Test of pop method, of class StackList.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackList instance = fillArray(); // Local - see above
        Employee result = instance.pop();
        assertEquals(222222, result.emId);
        assertEquals("Guy Last", result.emName);
    }

    /**
     * Test of printReverseList method, of class StackList.
     */
    @Test
    public void testPrintReverseList() {
        System.out.println("printReverseList");
        StackList instance = fillArray(); // Local - see above
        instance.printReverseList();
    }
    
}
