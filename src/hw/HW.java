/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;
import hw.*;
import java.math.BigInteger;

public class HW {

    public static void print_header (int taskNr, String descr){
        System.out.println("------------------------------------");
        System.out.printf("***\tHome work Task #02d\t***\t%s\n", taskNr, descr.toString());
    }
    

    public static void main(String[] args) {
 
        // Task 01
        CountBits cb = new CountBits();
        System.out.printf("MAX INT: %d bits\n", cb.countBits(Integer.MAX_VALUE));
        
        //Task02
        ChangeBit chb = new ChangeBit();
        System.out.println("ChangeBit(255,5,0) = " + chb.change_bit(255, 5, 0) + " = " + Integer.toBinaryString(chb.change_bit(255, 5, 0)));
        
        //Task03
        Karatsuba k = new Karatsuba();
        System.out.println(k.karatsuba_multiplication(BigInteger.ONE, new BigInteger("123456578901234567890")));
        
        //Task04 / euclideanGCD
        EuclideanGCD gcd = new EuclideanGCD(); 
        System.out.println("EuclideanGCD 240,66 = " + gcd.euclideanGCD(240, 96) );
        
        //Task05 / RSA
        new Task05(5);
        
        //Task06 / Figures.Area
        new Task06();
        
        //Task07.1 / Figures.Area
        new Task07_1();
        
        //Task07.2 / Figures.Area
        new Task07_2();
        
        
        
        LinkedList A = new LinkedList();
        A.insertLast( "1");
        A.insertFirst( "2f");        
        A.insertFirst( "8f");        
        A.insertFirst( "9f");        
        A.insertLast( "3");
        A.insertLast( "4");
        System.out.println("*FWD:");
        A.printList();
        System.out.println("*REV:");
        A.printReverseList();
        
        
        
    }
    
}



//        A pa = new A();
//        B pb = new B();
//        A pc = pb;
//        pa.sub(); System.out.println(pa.val); // classA::sub; val=1;  1
//        pb.sub(); System.out.println(pb.val); // classB::sub; val=2;  2
//        pc.sub(); System.out.println(pc.val); // classB::sub; val=2;  1
//       