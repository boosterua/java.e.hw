package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenericsSortMyClassTest {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;
    private GenericsSortMyClass sorter = new GenericsSortMyClass();
    private List list = sorter.list;


    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
            MyGenClass a = new MyGenClass(numbers[i]);
            list.add(a);
        }
    }

    @Test
    public void testNull() {
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        sorter.sort(null);
    }

    @Test
    public void testEmpty() {
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        sorter.sort(new ArrayList(0));
    }

    @Test
    public void testSimpleElement() {
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        ArrayList <MyGenClass> test = new ArrayList(1);
        test.add(new MyGenClass(5));
        sorter.sort(test);
    }


    @Test
    public void testQuickSort() {
        System.out.println(list);
        long startTime = System.currentTimeMillis();

        GenericsSortMyClass sorter = new GenericsSortMyClass();
        sorter.sort(list);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(list)) {
            fail("List failed to sort");
        }
        System.out.println("testQuickSort (Random) case, Array sorted:");
        printResult(sorter.list);
    }

    @Test
    public void testSpecial() {
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        for (int t: test)
            sorter.list.add(new MyGenClass(t));
        System.out.println(sorter.list);
        sorter.sort(sorter.list);
        
        if (!validate(sorter.list)) {
            fail("Failed. List is unsorted.");
        }
        System.out.println("testSpecial case, Array sorted:");
        printResult(sorter.list);
    }


    private boolean validate(List<?> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
//            System.out.print("|" + Integer.valueOf(numbers.get(i).toString()) + ">" +Integer.valueOf(numbers.get(i+1).toString()) +
  //                  "="+ (Integer.valueOf(numbers.get(i).toString()) > Integer.valueOf(numbers.get(i+1).toString()) ));
            if (    Integer.valueOf(numbers.get(i).toString())
                    >
                    Integer.valueOf(numbers.get(i+1).toString())) {
                return false;
            }
        }
        return true;
    }

    private void printResult(List<?> numbers) {
        for (int i = 0; i < numbers.size(); i++)
            System.out.print("[" + numbers.get(i) + "]");
        System.out.println();
    }

}

    /*
    @Test
    public void testTextElement() {
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        ArrayList <String> test = new ArrayList(2);
        test.add(new String("abc"));
        test.add(new String("def"));
        test.add(new String(""));
        test.add(new String("012"));
        sorter.sort(test);
        if (!validate(test)) {
            fail("List failed to sort");
        }        
        printResult(sorter.list);
    }
    */









///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hw;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author tonchief <ton.chief at tonchief.com>
// */
//public class GenericsSortMyClassMyClassTest {
//    
//    public GenericsSortMyClassMyClassTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of sort method, of class GenericsSortMyClassMyClass.
//     */
//    @Test
//    public void testSort() {
//        System.out.println("sort");
//        GenericsSortMyClassMyClass instance = new GenericsSortMyClassMyClass();
//        instance.sort(null);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of quickSort method, of class GenericsSortMyClassMyClass.
//     */
//    @Test
//    public void testQuickSort() {
//        System.out.println("quickSort");
//        int a = 0;
//        int b = 0;
//        GenericsSortMyClassMyClass instance = new GenericsSortMyClassMyClass();
//        instance.quickSort(a, b);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of swap method, of class GenericsSortMyClassMyClass.
//     */
//    @Test
//    public void testSwap() {
//        System.out.println("swap");
//        int i = 0;
//        int j = 0;
//        GenericsSortMyClassMyClass instance = new GenericsSortMyClassMyClass();
//        instance.swap(i, j);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of initializeWithArray method, of class GenericsSortMyClassMyClass.
//     */
//    @Test
//    public void testInitializeWithArray() {
//        System.out.println("initializeWithArray");
//        MyGenClass[] arr = null;
//        GenericsSortMyClassMyClass instance = new GenericsSortMyClassMyClass();
//        instance.initializeWithArray(arr);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class GenericsSortMyClassMyClass.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        GenericsSortMyClassMyClass.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
