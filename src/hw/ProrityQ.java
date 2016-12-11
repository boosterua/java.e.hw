package hw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonchief on 12/11/2016.
 *
 * 15. Реализовать алгоритм PriorityQueue(класс должен быть дженериком)
 */
public class ProrityQ<Item> implements Comparable<Item> {

    private List <Item> que = new ArrayList<>();
    private int size = 0;

    ProrityQ(){
    }

    public void insert(Item elem){
        int j = size;
        while (j>0 && elem.compareTo(que.get(j))>0){
            j++;
        }
        que.add(j, elem);
    }

    public Item peek(){
        return que.get(que.size());
    }

    public Item remove(){
        return que.remove(que.size());
    }

    public boolean isEmpty(){
        return que.size()==0;
    }

//    public int compareTo(E elem){
//        return this.elem - elem;
//    }

}

class Item <T extends Comparable<T>> implements Comparable<Item<T>>{
    private T key;
    Item(T key){
        this.key= key;
    }

    //@Override
    public String toString(Item key){
        return ""+key;
    }

    @Override
    public int compareTo(Item key) {
        return Integer.getInteger(this.key+"").compareTo(Integer.getInteger(key+""));
    }
}

/*
* Modifier and Type	Method and Description
boolean	add(E e)
Inserts the specified element into this priority queue.
void	clear()
Removes all of the elements from this priority queue.
Comparator<? super E>	comparator()
Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements.
boolean	contains(Object o)
Returns true if this queue contains the specified element.
Iterator<E>	iterator()
Returns an iterator over the elements in this queue.
boolean	offer(E e)
Inserts the specified element into this priority queue.
E	peek()
Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
E	poll()
Retrieves and removes the head of this queue, or returns null if this queue is empty.
boolean	remove(Object o)
Removes a single instance of the specified element from this queue, if it is present.
int	size()
Returns the number of elements in this collection.
Object[]	toArray()
Returns an array containing all of the elements in this queue.
<T> T[]	toArray(T[] a)
Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array.
*
* */