package hw;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.fail;

class _14_ListJoinSortTest {


    private final static int SIZE1 = 12;
    private final static int SIZE2 = 5;
    private final static int MAX = 998;
    private List<Worker> company1;
    private List<Worker> company2;
    private List<Worker> companyJoined;


    @Before
    public void setUp() throws Exception {
        Random generator = new Random();
        for (Integer i = 0; i < SIZE1; i++) {
            Worker a = new Worker("Name"+i, "Lname"+i, generator.nextInt(MAX));
            this.company1.add(a);
        }
        for (Integer i = 0; i < SIZE2; i++) {
            Worker a = new Worker("Name"+i, "Lname"+i, generator.nextInt(MAX));
            this.company2.add(a);
        }
    }

    @Test
    public void testNull() {
        ListJoinSort sorter = new ListJoinSort();
        companyJoined = sorter.listJoin(null, null);
        System.out.println(companyJoined);
    }

    @Test
    public void testEmpty() throws NullPointerException{
        ListJoinSort sorter = new ListJoinSort();
        List<Worker> companyEmpty = new ArrayList();
        try {
            companyEmpty.add(new Worker("", "", 0));
        } catch (Exception e){
            Thread.currentThread().getStackTrace();
        }
        companyJoined = sorter.listJoin(companyEmpty,companyEmpty);
        printResult(companyJoined);
    }

    @Test
    public void testSimpleElement() {
        ListJoinSort sorter = new ListJoinSort();
        List company1 = new ArrayList(){{
            add(new Worker("Vasia","Pup", 123));
        }};
        List company2 = new ArrayList(){{
            add(new Worker("Zhenia","Pup", 123));
        }};
        companyJoined = sorter.listJoin(company1,company2);
    }


    @Test
    public void TestListJoinSort () throws Exception {
        List<Worker> company1 = new ArrayList<>();
        List<Worker> company2 = new ArrayList<>();
        List<Worker> companyJoined;

        Random generator = new Random();

        for (Integer i = 0; i < SIZE1; i++) {
            Worker a = new Worker("Name"+i, "Lname"+i, generator.nextInt(MAX));
            company1.add(a);
        }
        for (Integer i = 0; i < SIZE2; i++) {
            Worker a = new Worker("Name"+i, "Lname"+i, generator.nextInt(MAX));
            company2.add(a);
        }
        ListJoinSort sorter = new ListJoinSort();
        long startTime = System.currentTimeMillis();
        sorter.listJoin(company1, company2);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(sorter.getList())) {
            fail("List failed to sort");
        }
        System.out.println("testQuickSort (Random) case, Array sorted:");
        printResult(sorter.getList());



        company1 = new ArrayList<>();
        company1.add(new Worker("John", "Leager", 1234567890));
        company1.add(new Worker("Greg", "Mouse", 1334567890));
        company1.add(new Worker("Kevin", "Eaton", 1434567890));

        company2 = new ArrayList<>();
        company1.add(new Worker("Gary", "Winter", 1934567890));
        company1.add(new Worker("Ivan", "Kanicky", 1834567890));
        company1.add(new Worker("Phillip", "Lenon", 1734567890));
        List <Worker> list = new ListJoinSort().listJoin(company1, company2);
        if (!validate(list)) {
            fail("List failed to sort");
        }
        printResult(list);

    }



    private boolean validate(List<Worker> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            return numbers.get(i).compareTo(numbers.get(i+1))<0;
//            if (    (numbers.get(i).toString()).compareTo((numbers.get(i+1).toString())) > 0)
//                return false;
        }
        return true;
    }

    private void printResult(List<?> numbers) {
        for (Object number : numbers) System.out.print("[" + number + "]\n");
        System.out.println();
    }























    @Test
    void listJoin() {

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

    @Test
    void main() {

    }

}