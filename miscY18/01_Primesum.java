/** @author D/L */
/** Q: What is the sum of the first 123456 prime numbers? */
/** A: use simple primality test */

import java.util.*;

public class Primesum {

    public static void main(String[] args) {
        
        int count = 0;
        int number = 2;
        long sum = 0;
        
        while(count < 123456){
            if(isPrimeNumber(number)){
                sum += number;
                count++;
            }
            number++;
        }
        System.out.println(sum);
    }

    private static boolean isPrimeNumber(int number){
        
        if (number <= 1) return false;
        
        if (number <= 3) return true;
 
        if (number % 2 == 0 || number % 3 == 0) return false;
 
        for ( int i = 5; i*i <= number; i = i + 6) {
            if ( number % i == 0 || number % (i+2) == 0)
                return false;
        }
 
        return true;
    }
}

    
