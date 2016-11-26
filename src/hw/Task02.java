package hw;

import old.HW;

public class Task02 extends HW{
    Task02(int task_nr){
        /*
         * Задание 2.
         * Используя побитовые операции изменить в переменной типа int бит с номером pos на единицу, на 0.
         */
        print_header(task_nr, null);
        change_bit(255, 5, 1 );
        change_bit(255, 5, 0 );        
        change_bit(18, 5, 1 );
        change_bit(18, 5, 0 );  
    }

    
    
    private static void change_bit(int num, int pos, int one_or_zero){
        int mask = (int) Math.pow(2.0, pos - 1);
        int result;
        if(one_or_zero == 1){
            result = num | mask; ;
        } else {
            mask = ~mask;
            result = (num & mask);
        }

        System.out.printf("Input: %d ; Bit Pos: %d ; Change to: %d; Result: %d\n",
                num, pos, one_or_zero, result );
        System.out.printf("\tNumber\t%32s\n\tMask \t%32s\n\tResult\t%32s\n", 
                (Integer.toBinaryString(num)),
                (Integer.toBinaryString(mask)),
                (Integer.toBinaryString(result))    );        
    }
    
}