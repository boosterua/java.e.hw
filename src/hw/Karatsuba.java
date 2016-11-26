package hw;

import java.math.BigInteger;
import java.util.Random;

public class Karatsuba { // Task03
    public BigInteger karatsuba_multiplication(BigInteger n1, BigInteger n2){
        /*
         * умножение методом Карацубы:
         * X = aT + b
         * Y = cT + d
         * XY =  ac + (ad + bc)T + bd T² 
         *                               = ac   +   ((a+b)(c+d) - ac - bd) * T + bd * T²
         *                                            _________
         *                                               pt0
         *                                 _______   --------------------------  ______
         *                                   pt1             pt2                   pt3
         */
        
        final int MAXNUMBITS = 64;
                        
        int T = Math.max(n1.bitLength(), n2.bitLength());
        if (T < MAXNUMBITS)
            return n1.multiply(n2);
        T = (T / 2) ;
        
        // n1 = a + 2^T b,   n2 = c + 2^T d
        BigInteger b = n1.shiftRight(T); 
        BigInteger a = n1.subtract(b.shiftLeft(T));
        BigInteger d = n2.shiftRight(T);
        BigInteger c = n2.subtract(d.shiftLeft(T));
        // System.out.printf("\t~debug~ T=%d; n1=%d; n2=%d; a %d b %d c %d d %d\n",T,n1,n2,a,b,c,d);                
 
        BigInteger ac  = karatsuba_multiplication(a, c);
        BigInteger bd  = karatsuba_multiplication(b, d);
        BigInteger pt0 = karatsuba_multiplication(a.add(b), c.add(d));
        BigInteger pt1 = ac;
        BigInteger pt2 = pt0.subtract(ac).subtract(bd).shiftLeft(T);
        BigInteger pt3 = bd.shiftLeft(2*T);
 
        return (pt1).add(pt2).add(pt3);  
    }   
}
