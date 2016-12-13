package hw.hw17;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tonchief on 12/13/2016.
 */

class CalcPLTest {
    private final static String error = "java.lang.IllegalArgumentException";

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    void getResult() {
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
    // error = "java.lang.IllegalArgumentException";
    void testErrors() throws Exception {
        try {
           String s = "-*5+(3+2)";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }

   @Test
   void testErrors2() throws Exception {
        String error = "java.lang.IllegalArgumentException";
        try {
            String s = "-1*5+(3+2)";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }

   @Test
   void testErrors3() throws Exception {
        try {
           String s = "2-*5+(3+2)";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }
   @Test
   void testErrors4() throws Exception {

        try {
           String s = "(5+(3+2)";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }
   @Test
   void testErrors5() throws Exception {

        try {
           String s = "5+3+2))";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }
   @Test
   void testErrors6() throws Exception {

        try {

           String s = "5+3+((2)";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }
   @Test
   void testErrors7() throws Exception {

        try {

           String s = "5+3++2";
            double res = new CalcPL(s).getResult();
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
   }
   @Test
   void testErrors8() {
        try {
            expectedEx.expect(IllegalArgumentException.class);
            String s = "5+(1)";
            double res = new CalcPL(s).getResult();
            System.out.println(res);
            fail("Expected Exception, but got OK. Res=" + res);
        } catch(Exception e){
            assertEquals(error, e.toString());
        }
    }



}