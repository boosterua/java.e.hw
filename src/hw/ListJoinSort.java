package hw;

import java.util.*;

/**
 * @author tonchief <ton.chief at tonchief.com>
 *  
 * 14. Написать generic метод объединения двух списков и 
 * c последующей сортировкой полученного списка.
 */
public class ListJoinSort<E extends Worker> {
    private List<E> listJ;

    public List<E> listJoin(List<E> list01, List<E> list02){
        if (list01==null || list02==null || (list01.isEmpty() && list02.isEmpty())){
            listJ = new ArrayList();
            return listJ;
        }
        listJ = new ArrayList(list01);
        listJ.addAll(list02);
        sort(listJ);
        return listJ;
    /*  MANUAL METHOD
        ArrayList<E> listJ = new ArrayList();
        for (E elem: list01) listJ.add(elem);
        for (E elem: list02) listJ.add(elem);
        return listJ;    */
    }

    public List<E> getList(){
        return this.listJ;
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
        while (i<=j){
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

        List<Worker> company1 = new ArrayList<>();
            company1.add(new Worker("John", "Leager", 1234567890));
            company1.add(new Worker("Greg", "Mouse", 1334567890));
            company1.add(new Worker("Kevin", "Eaton", 1434567890));

        List<Worker> company2 = new ArrayList<>();
            company1.add(new Worker("Gary", "Winter", 1934567890));
            company1.add(new Worker("Ivan", "Kanicky", 1834567890));
            company1.add(new Worker("Phillip", "Lenon", 1734567890));

        List <Worker> list = new ListJoinSort().listJoin(company1, company2);
        System.out.println(list);
    }


}

class Worker implements Comparable<Worker>{
    private String firstName;
    private String lastName;
    private Long taxId;

    public Worker(String firstName, String lastName, long taxId){
        if (firstName == null || lastName == null || taxId<=0)
            throw new NullPointerException();
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxId = taxId;
    }

    public String name(){
        return this.firstName+" "+this.lastName;

    }

    public String toString(){
        return ""+ this.taxId + ". "+ name() + "";
    }


    @Override
    public int compareTo(Worker employee) {
        return taxId.compareTo(employee.taxId);
    }
}


//class Custom <E extends Comparable<E>> implements Comparable<Custom> {
//    private Collection<? extends E> data;
//    private E   e;
//
//    Custom (Object e){
//        this.e = (E)e;
//    }
//
//    @Override
//    public int compareTo(Custom custom) {
//        return e.compareTo((E)custom);
//    }
//}







