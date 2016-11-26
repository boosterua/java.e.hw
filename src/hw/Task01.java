package hw;

import old.HW;

public class Task01 extends HW{
    Task01(int task_nr){
        /*
         * Задание 1.
         * Используя побитовые операции подсчитать количество занимаемых би т для byte,short, int, long
         */
        print_header(task_nr, null);
        count_bits_and_print(Byte.MAX_VALUE,    "Byte");
        count_bits_and_print(Short.MAX_VALUE,   "Short");
        count_bits_and_print(Integer.MAX_VALUE, "Int");
        count_bits_and_print(Long.MAX_VALUE,    "Long");
        
    }

    private static void count_bits_and_print(long num, String text){
        int num_of_bits = 1;
        do {
            num >>=  1;
            num_of_bits++;
        } while (num>0);
        System.out.println(text + "\t > " + num_of_bits + " bits");            
    }    
    
}