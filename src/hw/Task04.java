
package hw;

import static old.HW.print_header;
import java.util.Random;


public class Task04 {

    public Task04(int val) {
         /*
         * HW 4. // Euclidean algorithm:: Greatest common divisor
         */
         
        print_header(4, "Euclidean algorithm:: Greatest common divisor");
        int n1 = (int) new Random().nextInt(Integer.MAX_VALUE);
        int n2 = (int) new Random().nextInt(Integer.MAX_VALUE);

        //    n1 = 6; n2 = 9; /* Simple check */
        
        System.out.printf( "euclideanGCD(%d,%d)=%d\n", n1, n2, euclideanGCD(n1, n2) );
        // Test 
//        System.out.println( (n1.multiply(n2)).toString() + " - test result calculated with BigInteger multiply" );
    }
    
    public static int euclideanGCD(int a, int b) {
            if (a == b) return a;
            if (a == 0) return b;
            if (b == 0) return a;
            if ((~a & 1) != 0) {
                    if ((b & 1) != 0)
                            return euclideanGCD(a >> 1, b);
                    else
                            return euclideanGCD(a >> 1, b >> 1) << 1;
            }
            if ((~b & 1) != 0)
                    return euclideanGCD(a, b >> 1);
            if (a > b)
                    return euclideanGCD((a - b) >> 1, b);
            return euclideanGCD((b - a) >> 1, a);
    }
}
