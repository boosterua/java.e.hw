package hw;

public class CountBits {
    
    public int countBits(long num){
        int num_of_bits = 1;
//        String descr;
        long number; //debug    System.out.println("*"+Integer.toBinaryString((int)num));
        do {
            num >>=  1;
            num_of_bits++;  //debug     System.out.println("*"+Integer.toBinaryString((int)num));
        } while (num>0);
        return num_of_bits;
    }        
}
