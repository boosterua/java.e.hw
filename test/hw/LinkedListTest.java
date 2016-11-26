/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

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
public class LinkedListTest {
    
    public LinkedListTest() {
    }
        
    public LinkedList fillArray(){
        LinkedList A = new LinkedList();
        A.insertLast( "Guy Last");
        A.insertLast("Emma Jackson");
        A.insertLast("Peter Ackwell");
        A.insertLast("Gary Eaton");
        A.insertFirst( "Guy First");        
        return A;
    }

    /**
     * Test of insertFirst method, of class LinkedList.
     */
    @Test
    public void testInsertFirst() {
        System.out.println("insertFirst");
        Object elem = "Test1";
        LinkedList instance = new LinkedList();
        instance.insertFirst(elem);
        assertEquals(elem, instance.first.element);
        instance.insertFirst("Test2");
        assertEquals("Test2", instance.first.element);
    }

    /**
     * Test of insertLast method, of class LinkedList.
     */
    @Test
    public void testInsertLast() {
        System.out.println("insertLast");
        Object elem = "Test1";
        LinkedList instance = new LinkedList();
        instance.insertLast(elem);
        assertEquals(elem, instance.last.element);
        instance.insertLast(null);
        assertEquals(null, instance.last.element);
    }

    /**
     * Test of popFirst method, of class LinkedList.
     */
    @Test
    public void testPopFirst() {
        System.out.println("popFirst");
        LinkedList instance = fillArray();
        LinkedList.Item result = instance.popFirst();
        assertEquals("Guy First", result.element);
        
// Check for non existing elements. NPE
        result = instance.popFirst();
        result = instance.popFirst();
        result = instance.popFirst();
        result = instance.popFirst();
        result = instance.popFirst();
        result = instance.popFirst();
        result = instance.popFirst();
    }

    /**
     * Test of popLast method, of class LinkedList.
     */
    @Test
    public void testPopLast() {
        System.out.println("popLast");
//        LinkedList instance = new LinkedList();
        LinkedList instance = fillArray();
        LinkedList.Item expResult = null;
        LinkedList.Item result = instance.popLast();
        assertEquals("Gary Eaton", result.element);
    }

    /**
     * Test of printList method, of class LinkedList.
     */
    @Test
    public void testPrintList() {
        System.out.println("printList");
        LinkedList instance = fillArray();
        instance.printList();
    }

    /**
     * Test of printReverseList method, of class LinkedList.
     */
    @Test
    public void testPrintReverseList() {
        System.out.println("printReverseList");
        LinkedList instance = fillArray();
        instance.printReverseList();
    }
    
}
