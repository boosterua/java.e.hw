package hw;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tonchief on 12/04/2016.
 * 13.  Используя generics написать сортировку списка, в котором могут храниться
 * элементы некоторого класса или его наследников методом Quicksort,
 * сравнение элементов осуществлять с помощью Comparator
 * @param <E>
 * @param <Comparator>
 */

public class  GenericsSortMyClass <E extends Comparable<E>, MyGenClass> {
    int i=-1;
    int j=0;
    int pivot;
    public List <E> list = new ArrayList();
    
    public void sort(List <E> list){
        this.list = list;
        sort();
    }

    public void sort(){
        if(list==null || list.isEmpty()) return;
        int max = list.size();  // System.out.println("MAX:"+max);
        quickSort(0, max - 1);
    }

    private void quickSort(int a, int b){
        int i = a; int j = b;
        E pivot = list.get(a + (b-a)/2);
        while (i<=j){
              while (list.get(i).compareTo(pivot) < 0) i++;
              while (list.get(j).compareTo(pivot) > 0) j--;
            if (i<=j) {
                swap(i ,j);
                i++;
                j--;
            }
        }
        if (a < j) quickSort(a, j);
        if (i < b) quickSort(i, b);
    }

    private void swap(int i, int j){
        if (i==j) return;
        E t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    public void initializeWithArray(E[] arr){
        for (E el: arr)
            list.add(el);
    }
    
    public static void main(String[] args) {
        // * TEST:
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        Integer[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        for (int t: test)
            sorter.list.add(t);
        sorter.sort(sorter.list);
        System.out.println(sorter.list);
        
    }
}



class MyGenClass implements Comparable {
    Object o;
    Integer id;
    String name;
    
    MyGenClass(Object o){
        this.o = o;
    }
    MyGenClass(Integer id){
        this.id = id;
    }
    MyGenClass(String name){
        this.name = name;
    }
    MyGenClass(Integer id, String name){
        this.name = name;
        this.id = id;
    }
    

    @Override
    public int compareTo(Object t) {
        return this.id.compareTo(((MyGenClass)t).id);
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof MyGenClass))
            return false;
        return this.equals(o);
    }
    @Override
    public String toString(){
        return this.id.toString(); // + this.name.toUpperCase()
    }
}

/*
public class  GenericsSortMyClass <E extends MyGenClass, Comparator> {
    int i=-1;
    int j=0;
    int pivot;
    private ArrayList <E> list;
//    static MyGenClassComparator comparator = new MyGenClassComparator();
    
    public void sort(ArrayList <E> list){
        if(list==null || list.isEmpty()) return;
        this.list = list;
        int max = list.size();  // System.out.println("MAX:"+max);
        quickSort(0, max - 1);
    }

    private void quickSort(int a, int b){   //        System.out.println("a="+a+"; b="+b + " ;list sise="+list.size());
        int i = a; int j = b;
        E pivot = list.get(a + (b-a)/2);
        while (i<=j){
//            while (comparator.compare(list.get(i), pivot) < 0) i++;
//            while (comparator.compare(list.get(j), pivot) > 0) j--;
              while (list.get(i).compareTo(pivot) < 0) i++;
              while (list.get(j).compareTo(pivot) > 0) j--;
            if (i<=j) {
                swap(i ,j);
                i++;
                j--;
            }
        }
        if (a < j) quickSort(a, j);
        if (i < b) quickSort(i, b);
    }

    private void swap(int i, int j){
        if (i==j) return;
        E t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    public void initializeWithArray(E[] arr){
        for (E el: arr)
            list.add(el);
    }
    
    public static void main(String[] args) {
        // * TEST:
        GenericsSortMyClass sorter = new GenericsSortMyClass();
        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        for (int t: test)
            sorter.list.add(t);
        sorter.sort(sorter.list);
        System.out.println(sorter.list);
        
    }
}



class MyGenClass implements Comparable {
    Object o;
    Integer id;
    String name;
    
    MyGenClass(Object o){
        this.o = o;
    }
    MyGenClass(Integer id){
        this.id = id;
    }
    MyGenClass(String name){
        this.name = name;
    }
    MyGenClass(Integer id, String name){
        this.name = name;
        this.id = id;
    }
    

    @Override
    public int compareTo(Object t) {
        return this.id.compareTo(((MyGenClass)t).id);
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof MyGenClass))
            return false;
        return this.equals(o);
    }
    @Override
    public String toString(){
        return this.id.toString(); // + this.name.toUpperCase()
    }
}


class MyGenClassComparator <MyGenClass extends Comparable<MyGenClass>> implements Comparator<MyGenClass> {
    @Override
    public int compare(MyGenClass a, MyGenClass b) {
        //check int or string
        //System.out.println(a.toString() +" "+ b.toString() +" " + a.toString().compareTo(b.toString()));
        return (a.compareTo(b));
    }
}

*/