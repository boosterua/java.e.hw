package hw;

public class EuclideanGCD {
    public int euclideanGCD(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            if (a == b) return a;
            if (a == 0) return b;
            if (b == 0) return a;
            if ((~a & 1) != 0) {
                    if ((b & 1) != 0)
                            return euclideanGCD(a >> 1, b);
                    else
                            return euclideanGCD(a >> 1, b >> 1) << 1;
            }
            if ((~b & 1) != 0)
                    return euclideanGCD(a, b >> 1);
            if (a > b)
                    return euclideanGCD((a - b) >> 1, b);
            return euclideanGCD((b - a) >> 1, a);
    }    
}
