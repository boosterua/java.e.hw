package hw;

import java.util.*;

/**
 * @author tonchief <ton.chief at tonchief.com>
 *  
 * 14. Написать generic метод объединения двух списков и 
 * c последующей сортировкой полученного списка.
 */
public class ListJoinSort<E extends Custom> {


    List<E> list1 = new ArrayList<>();
    List<E> list2 = new ArrayList<>();
    List<E> listJ = listJoin(list1, list2);

    public List listJoin(List list01, List list02){
        List listJ = new ArrayList(list01);
        listJ.addAll(list02);
        sort(listJ);
        return listJ;
    /*  MANUAL METHOD
        ArrayList<E> listJ = new ArrayList();
        for (E elem: list01) listJ.add(elem);
        for (E elem: list02) listJ.add(elem);
        return listJ;
    */
    }

    private List<E> sort(List<E> list){
        if(list==null || list.isEmpty())
            return Collections.emptyList();
        int max = list.size();
        quickSort(0, max - 1, list);
        return list;
    }


    private void quickSort(int a, int b, List<E> list){
        int i = a;
        int j = b;
        E pivot = list.get(a + (b-a)/2);
//        String pivotStr = pivot.toString();
        while (i<=j){
//            while (list.get(i).toString().compareTo(pivotStr) < 0 )
            while (list.get(i).compareTo(pivot) < 0 )
                i++;
            while (list.get(j).compareTo(pivot) > 0)
                j--;
            if (i<=j) {
                // Swap:
                if (i!=j) {
                    E t = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, t);
                }
                i++;
                j--;
            }
        }
        if (a < j)
            quickSort(a, j, list);
        if (i < b)
            quickSort(i, b, list);
    }

    public static void main(String[] args) {
//        List<String> list1 = new ArrayList<>();
//            list1.add(new Custom<String> ("A"));
//            list1.add("D");
//            list1.add("C");
//
//        List<String> list2 = new ArrayList<String>() {{
//            add("F");
//            add("B");
//            add("E");
//        }};
//        Factory fac = new Factory();

        List<String> list1 = new ArrayList<>();
            list1.add(new Custom("A");
            list1.add("D");
            list1.add("C");

        List<String> list2 = new ArrayList<String>() {{
            add("F");
            add("B");
            add("E");
        }};

        List <Custom> list = new ListJoinSort().listJoin(list1, list2);
//        list.li
        System.out.println(list);
    }


}

class MyClass<E> {
    private final Collection<? extends E> data;
    MyClass(Comparator<E> comparator, Collection<? extends E> data) {
        this.data = data;
    }
    public void processData() {
        // ...
    }
}
class Factory {
    static <E extends Comparable<E>> MyClass<E> create(Collection<? extends E> data) {
        return new MyClass<E>(new Comparator<E>() {
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        }, data);
    }
//    static <T> MyClass<T> create(Comparator<T> comparator, Collection<? extends T> data) {
//        return new MyClass<T>(comparator, data);
//    }
}


class Custom <E extends Comparable<E>> implements Comparable<Custom> {
    private Collection<? extends E> data;
    private E   e;

    Custom (Object e){
        this.e = (E)e;
    }

    @Override
    public int compareTo(Custom custom) {
        return e.compareTo((E)custom);
    }
}


//
//class Util <E> {
//
//    public static List listJoin(List list01, List list02){
//        List listJ = new ArrayList(list01);
//        listJ.addAll(list02);
//        return listJ;
//    /*  MANUAL METHOD
//        ArrayList<E> listJ = new ArrayList();
//        for (E elem: list01) listJ.add(elem);
//        for (E elem: list02) listJ.add(elem);
//        return listJ;
//    */
//    }
//    public List<E> sort(List<E> list){
//        if(list==null || list.isEmpty())
//            return Collections.emptyList();
//        int max = list.size();
//        quickSort(0, max - 1, list);
//        return list;
//    }
//
//
//    private void quickSort(int a, int b, List<E> list){
//        int i = a;
//        int j = b;
//        E pivot = list.get(a + (b-a)/2);
//        String pivotStr = pivot.toString();
//        while (i<=j){
//            while (list.get(i).toString().compareTo(pivotStr) < 0 )
//                i++;
//            while (list.get(j).toString().compareTo(pivotStr) > 0)
//                j--;
//            if (i<=j) {
//                // Swap:
//                if (i!=j) {
//                    E t = list.get(i);
//                    list.set(i, list.get(j));
//                    list.set(j, t);
//                }
//                i++;
//                j--;
//            }
//        }
//        if (a < j)
//            quickSort(a, j, list);
//        if (i < b)
//            quickSort(i, b, list);
//    }
//
//
////    @Override
////    public int compareTo(Object o) {
////        return 0;
////    }
//}
//













