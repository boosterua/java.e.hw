package hw.hw15priorityque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tonchief on 12/11/2016.
 *
 * 15. Реализовать алгоритм PriorityQueue(класс должен быть дженериком)
 */
public class PrioQ<T extends Comparable<T>> implements Comparator<T> {

    public List<T> que = new ArrayList<>();
    private int size = 0;

    PrioQ(){
    }

    void insert(T elem){
        if (elem==null) return;
        int j = que.size()-1;
        if(j==-1) {
            que.add(elem);
        } else {
            while (j >= 0) {
                if (compare(elem, que.get(j)) > 0)
                    break;
                j--;
            }
            que.add(j+1 , elem);
        }
    }

    public T peek(){
        int lastElem = que.size()-1;
        if(lastElem<0)
            return null;
        return que.get(lastElem);
    }

    public T remove(){
        int lastElem = que.size()-1;
        if(lastElem<0)
            return null;
        T elem = que.get(lastElem);
        que.remove(lastElem);
        return elem;
    }

    public boolean isEmpty(){
        return que.isEmpty();
    }

    List<String> getList(){
        List <String> arr = new ArrayList();
        for (T elem: que) {
            T t = (T) elem;
            arr.add(elem+"");
        }
        return arr;
    }

    @Override
    public int compare(T a, T b){
        return a.toString().compareTo(b.toString());
    }


}

class Test{
    public static void main(String[] args) {
        PrioQ q = new PrioQ();
        q.insert(new Integer(8));
        q.insert(new Integer(2));
        q.insert(new Integer(5));
        q.insert(new Integer(9));
        q.insert(new Integer(1));
        q.insert(new Integer(6));
        System.out.println(q.getList());
    }

}



















/*



class Item <T extends Number>  implements Comparable{


    public T key;

    Item(){}

    Item(T key){
        this.key = key;
    }

    public T getKey(){
        return this.key;
    }

      //@Override
    public String toString(T key){
        return ""+key;
    }

//    @Override
//    public int compareTo(T t) {
//        return Integer.getInteger(this.key+"").compareTo(Integer.getInteger(key+""));
//    }

    @Override
    public int compareTo(Object o) {
        return Integer.getInteger(this.key+"").compareTo(Integer.getInteger(o+""));
    }
}





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