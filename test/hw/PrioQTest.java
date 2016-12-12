package hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by tonchief on 12/12/2016.
 */
class PrioQTest {
    //@org.junit.jupiter.api.Test


    void insert() {

        PrioQ q = new PrioQ();
        q.insert(new Integer(8));
        q.insert(new Integer(2));
        q.insert(5);
        q.insert(9);
        q.insert(1);
        q.insert(6);
        q.insert("ABC");
        q.insert("AAAA");
        q.insert("DFFF");
        q.insert(null);

        assertEquals(q.que, new ArrayList () {{
            add(1);
            add(2);
            add(5);
            add(6);
            add(8);
            add(9);
            add("AAAA");
            add("ABC");
            add("DFFF");
        }});
        System.out.println(q.getList());

    }



    @Test
    void peek() {

        PrioQ q = new PrioQ();
        q.insert(new Integer(8));
        q.insert(new Integer(2));
        q.insert(5);
        q.insert(9);
        q.insert(1);
        q.insert(6);
        q.insert("ABC");
        q.insert("AAAA");
        q.insert("DFFF");
        System.out.println("Peek:" + q.peek());
        assertEquals("DFFF", q.peek() );
        assertEquals("DFFF", q.remove() );

        // removing all, then trying to get more

        for (int i=0; i<100; i++){
            Object elem = q.remove();
            System.out.println(i + ") " + elem);
            if (elem==null) break;
        }

        // Trying illegal operation
        // Remove from empty
        assertNull(q.remove() );
    }

    @Test
    void remove() {
        // see peek;
    }

    @Test
    void isEmpty() {

    }

    @Test
    void compare() {

    }

}





/*


        System.out.println("? PEEK:" + q.peek());
        System.out.println("-Remove:" + q.remove());
        System.out.println(q.getList());
 */