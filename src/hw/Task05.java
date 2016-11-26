package hw;

import old.HW;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Task05 extends HW {
    public Task05(int val) {
        /*
         * HW 5. // RSA algorithm 
         */
         
        print_header(5, "RSA algorithm.");
        RSA rsa = new RSA();
        rsa.printKeys();
        List encodedMsg = rsa.encrypt(
            "Oh, say! can you see by the dawn's early light \n" +
            "What so proudly we hailed at the twilight's last gleaming; \n" +
            "Whose broad stripes and bright stars, through the perilous fight, \n" +
            "O'er the ramparts we watched were so gallantly streaming? \n" +
            "And the rocket's red glare, the bombs bursting in air, \n" +
            "Gave proof through the night that our flag was still there: \n" +
            "Oh, say! does that star-spangled banner yet wave \n" +
            "O'er the land of the free and the home of the brave?");
        System.out.println("\t* " + encodedMsg + " << Encoded");
        System.out.println("" + rsa.decrypt(encodedMsg));
                
        encodedMsg = rsa.encrypt("Hello, world of cryptography ;)");
        System.out.println("\t*" + encodedMsg + " << Encoded");
        System.out.println("" + rsa.decrypt(encodedMsg));
                
    }
    
    static class KeySet{ // not used anymore.
        BigInteger e, d, n; // open key: e,n; pvt.key: d,n. 
        KeySet(BigInteger E, BigInteger D, BigInteger N){
            this.e = E;
            this.d = D;
            this.n = N;
        }
    }

class RSA{
    
    BigInteger e, d, n; // open key: e,n; pvt.key: d,n. 
    int bitLength = 4; // 3+!  set lower values (like 3) to see the split in words, not letters
    final BigInteger adyn = new BigInteger("1");
    final BigInteger zero = new BigInteger("0");
    List <String> dictionary = new ArrayList();
    HashMap <String, Integer> dictVK = new HashMap();    

            
    RSA(){
        this.generateKeys();
    }
    
    public List <BigInteger> encrypt(String message){
        BigInteger ml = BigInteger.valueOf(message.length());
        BigInteger pcSize = ml.divide(this.n.subtract(adyn)).add(adyn);
        List <String> words = splitEqually(message, pcSize.intValue());
        TreeSet <String> set = new TreeSet (words);
        List <BigInteger> encryptedList = new ArrayList();
        dictionary = new ArrayList(set);

        // create dictVK - value/key as opposed to key/val;
        for (int i=0; i<dictionary.size(); i++) dictVK.put(dictionary.get(i), i);
        
        System.out.printf("%s\n\t* msgLength=%s; pieceSize=%s;\n\t* DICTIONARY: %s\n\t* ",
                message, ml, pcSize, (String.join("|", dictionary)).replace("\n", "\\n")   );
        
        for (String word : words){
            BigInteger hash = BigInteger.valueOf(dictVK.get(word)).pow(e.intValue()).mod(n);
            encryptedList.add(hash);
            System.out.print(dictVK.get(word) + "; ");
        }
        System.out.println("< before encode");

        return encryptedList;
    }
    
    public String decrypt(List <BigInteger> encoded){
        String message="";
        System.out.print("\t* ");
                
        for (int i=0; i<encoded.size(); i++){
            BigInteger hashDecoded = encoded.get(i).pow(d.intValue()).mod(n) ;
            message+=dictionary.get(hashDecoded.intValue());
            System.out.print(hashDecoded.intValue()+", ");
            
        }
        System.out.println("<<< Decoded");
        return message;        
    }
    
    
    
    public void printKeys(){ /* (KeySet ks) */   //        System.out.printf("%s %s %s",ks.e,ks.d,ks.n);
        System.out.printf("\t* open key e=%s, n=%s; secret keys d=%s, n=%s\n",e,n,d,n);
    }
    
    public KeySet generateKeys(){
        BigInteger p = BigInteger.probablePrime(bitLength, new Random());
        BigInteger q;
        // This f*ing shit doesn't work if p&q are equal !!!
        do{ q = BigInteger.probablePrime(bitLength, new Random());} while (q.equals(p));
        
        
        BigInteger n = p.multiply(q);
        BigInteger f = (p.subtract(adyn)).multiply(q.subtract(adyn));
        BigInteger d = BigInteger.probablePrime(p.min(q).bitLength()-1, new Random());
//            System.out.printf("%s %s %s",f,d,f.mod(d));    
            while (f.mod(d).equals(zero) || d.mod(f).equals(zero)){
                d = d.nextProbablePrime(); 
            }
  System.out.printf("\t* p=%s; q=%s; ",p,q);            
        BigInteger e = zero;
                

   
  
        while (true){
            if((e.multiply(d)).mod(f).equals(adyn)) break;
            e = e.add(adyn);    //  System.out.println("e = " + e);
        }
                // System.out.printf("f=%s, open key e=%s, n=%s; secret keys d=%s, n=%s\n",f,e,n,d,n);
        this.e = e;
        this.d = d;
        this.n = n;

        return new KeySet(e, d, n);
                
        
    }
    
    public long generatePrivateKey(){
        return (long) (1);
    }
    public long generatePublicKey(){
        return (long) 1;
    }
    

            
}

public static List<String> splitEqually(String text, int size) {
    // Give the list the right capacity to start with. You could use an array
    // instead if you wanted.
    List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

    for (int start = 0; start < text.length(); start += size) {
        ret.add(text.substring(start, Math.min(text.length(), start + size)));
    }
    return ret;
}

}



/*
***	Home Work: Task #05	***	RSA algorithm.
open key e=103, n=143; secret keys d=7, n=143
msgLength=31; pieceSize=1;
[ , ), ,, ;, H, a, c, d, e, f, g, h, l, o, p, r, t, w, y]
[ , ), ,, ;, H, a, c, d, e, f, g, h, l, o, p, r, t, w, y]
4; 8; 12; 12; 13; 2; 0; 17; 13; 15; 12; 7; 0; 13; 9; 0; 6; 15; 18; 14; 16; 13; 10; 15; 5; 14; 11; 18; 0; 3; 1; < before encode
[108, 83, 12, 12, 52, 63, 0, 95, 52, 141, 12, 123, 0, 52, 113, 0, 7, 141, 112, 27, 81, 52, 10, 141, 125, 27, 132, 112, 0, 16, 1] << Encoded
4, 8, 12, 12, 13, 2, 0, 17, 13, 15, 12, 7, 0, 13, 9, 0, 6, 15, 18, 14, 16, 13, 10, 15, 5, 14, 11, 18, 0, 3, 1, <<< Decoded

open key e=29, n=169; secret keys d=5, n=169
msgLength=31; pieceSize=1; 
WRONG






*/   


            //        while (f.compareTo(e)==1 & false){
            //            System.out.print(e);            System.out.print("  ");
            //            System.out.print(d);            System.out.print("  ");
            //            System.out.print(f);            System.out.print("\n");
            //            if( (d.multiply(e)).mod(f) == adyn ){
            //                break;
            //            }
            //            e = e.add(adyn);
            //        }
            //        int i=0;
            //        BigInteger ff = f;
            //        BigInteger div;
            //        while(true){
            //            ff = ff.add(f);
            //            div = ff.divide(d).add(adyn);
            //            if (div.multiply(f).mod(d)==adyn) 
            //                break;
            //        System.out.printf("ff=%s, div=%s; d=%s; f=%s\n",ff,div,d,f);    
            //        }
            //        BigInteger N = zero;
            //        while(true){
            //            N = N.add(adyn);
            //        System.out.printf("N=%s; d=%s; f=%s; mask=%s\n",N,d,f,f.multiply(N.add(adyn)).mod(d));    
            //            if (f.multiply(N.add(adyn)).mod(d).equals(zero))
            //                break;
            //
            //        }
            //        e = f.multiply(N.add(adyn).add(adyn)).divide(d);
            //        System.out.println(e.multiply(d).mod(f));
            //        System.out.println(f.multiply(N.add(adyn).add(adyn)).divide(d).multiply(d).mod(f));
            //        System.out.println(f.multiply(N.add(adyn)).divide(d).multiply(d).mod(f));
            //        System.out.println(f.multiply(N).divide(d).multiply(d).mod(f));
            //System.out.printf(" d=%s; f=%s; \n",d,f);    