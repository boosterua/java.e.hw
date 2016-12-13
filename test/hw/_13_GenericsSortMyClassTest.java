package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class _13_GenericsSortMyClassTest {
    @Test
    public void addValue() throws Exception {

    }

    @Test
    public void sort() throws Exception {

    }

    @Test
    public void sort1() throws Exception {

    }

    @Test
    public void initializeWithArray() throws Exception {

    }

    @Test
    public void printList() throws Exception {

    }

    @Test
    public void getList() throws Exception {

    }

    @Test
    public void main() throws Exception {

    }

    private final static int SIZE = 12;
    private final static int MAX = 98;
    private GenericsSortMyClass sorter = new GenericsSortMyClass();


    @Before
    public void setUp() throws Exception {
        int[] numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
            sorter.addValue(numbers[i]);
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
        ArrayList <Integer> test = new ArrayList(1);
        test.add(5);
        sorter.sort(test);
    }


    @Test
    public void testQuickSort() {
        sorter.printList();
        long startTime = System.currentTimeMillis();
        sorter.sort();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(sorter.getList())) {
            fail("List failed to sort");
        }
        System.out.println("testQuickSort (Random) case, Array sorted:");
        printResult(sorter.getList());
    }

    @Test
    public void testSpecial() {
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        for (int t: test)
            sorter.addValue(t);
        sorter.printList();
        sorter.sort();
        
        if (!validate(sorter.getList())) {
            fail("Failed. List is unsorted.");
        }
        System.out.println("testSpecial case, Array sorted:");
        sorter.printList();
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
        for (Object number : numbers) System.out.print("[" + number + "]");
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
