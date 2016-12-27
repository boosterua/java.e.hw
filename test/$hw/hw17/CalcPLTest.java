package $hw.hw17;

import org.junit.Rule;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;



/**
 * Created by tonchief on 12/13/2016.
 */

/*
public class CalcPLTest {
    private final static String error = "java.lang.ArithmeticException";
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void getResult() {
        String s = "";
        s = "1*5+(3+2)";
        assertEquals(10.0, new CalcPL(s).getResult(), 0.01);
        s = "(1+2)*4+5*(3+6)";
        assertEquals(57f, new CalcPL(s).getResult(), 0.01);
        s = "(1+2)";
        assertEquals(3f, new CalcPL(s).getResult(), 0.01);
        s = "2";
        assertEquals(2f, new CalcPL(s).getResult(), 0.01);
        s = "(5)+1";
        assertEquals(6f, new CalcPL(s).getResult(), 0.01);
        s = "5+(1)";
        assertEquals(6f, new CalcPL(s).getResult(), 0.01);
    }

    @Test
    // error = "java.lang.ArithmeticException";
    public void testErrors() throws Exception {
            expectedEx.expect(ArithmeticException.class);
           String s = "-*5+(3+2)";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);

   }

   @Test
   public void testErrors2() throws Exception {
        expectedEx.expect(ArithmeticException.class);
        String s = "-1*5+(3+2)";
        double res = new CalcPL(s).getResult();
        System.out.println(res);
        fail("Expected Exception, but got OK. Res=" + res);
   }

   @Test
   public void testErrors3() throws Exception {
       expectedEx.expect(ArithmeticException.class);
       String s = "2-*5+(3+2)";
       double res = new CalcPL(s).getResult();
       System.out.println(res);
       fail("Expected Exception, but got OK. Res=" + res);
   }

   @Test
   public void testErrors4() throws Exception {

       expectedEx.expect(ArithmeticException.class);
       String s = "(5+(3+2)";
       double res = new CalcPL(s).getResult();
       System.out.println(res);
       fail("Expected Exception, but got OK. Res=" + res);
   }

   @Test
   public void testErrors5() throws Exception {
       expectedEx.expect(ArithmeticException.class);
       String s = "5+3+2))";
       double res = new CalcPL(s).getResult();
       System.out.println(res);
       fail("Expected Exception, but got OK. Res=" + res);

   }

   @Test
   public void testErrors6() throws Exception {
        expectedEx.expect(ArithmeticException.class);
        String s = "5+3+((2)";
        double res = new CalcPL(s).getResult();
        System.out.println(res);
        fail("Expected Exception, but got OK. Res=" + res);
   }

   @Test
   public void testErrors7() throws Exception {
            expectedEx.expect(ArithmeticException.class);
            String s = "5+3++2";
            double res = new CalcPL(s).getResult();
            System.out.println(res);
            fail("Expected Exception, but got OK. Res=" + res);
   }


   @Test
   public void testErrors8() throws Exception {
           expectedEx.expect(ArithmeticException.class);
           String s = "5+1)";
           double res = new CalcPL(s).getResult();
           System.out.println(res);
           fail("Expected Exception, but got OK. Res=" + res);
   }



}

*/