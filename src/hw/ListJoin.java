package hw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author tonchief <ton.chief at tonchief.com>
 *  
 * 14. Написать generic метод объединения двух списков и 
 * c последующей сортировкой полученного списка.
 */
public class ListJoin<T extends Custom> {


    ArrayList<T> list1 = new ArrayList<>();
    ArrayList<T> list2 = new ArrayList<>();
    //    ArrayList<Integer> listJ = new ArrayList<Integer>();
    ArrayList<T> listJ = Util.listJoin(list1, list2);
    //Sort
    ListJoin(){
//        Collections.sort(listJ);
    }
    
}


class Custom <E extends Comparable<E>>{

//    @Override
    public int compareTo(E t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}



class Util <T>{

    public static ArrayList listJoin(ArrayList list01, ArrayList list02){

        ArrayList listJ = new ArrayList(list01);
        listJ.addAll(list02);
        
    /*  MANUAL METHOD
        ArrayList<E> listJ = new ArrayList();
        for (E elem: list01) listJ.add(elem);
        for (E elem: list02) listJ.add(elem);
    */
        
        return listJ;
    }
}