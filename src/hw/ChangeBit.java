package hw;

public class ChangeBit {
    public int change_bit(int num, int pos, int one_or_zero){
        int mask = (int) Math.pow(2.0, pos - 1);
        int result;
        if(one_or_zero == 1){
            result = num | mask; ;
        } else {
            mask = ~mask;
            result = (num & mask);
        }
        return result;
    }
}
