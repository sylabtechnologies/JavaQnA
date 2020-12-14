package dec12lambdad;


import java.math.BigInteger;
import java.util.ArrayList;

// #D return lambdas to the spec:
interface PerformOperaton
{
    public String perform(int n);
}
        
public class Dec12LambdaD
{
    public static void main(String[] args)
    {
        PerformOperaton a = isOdd();
        PerformOperaton b = isPrime();
        PerformOperaton c = isPalindrome();
        
        int test[] = {1,2,3,4,5,11,10};
        for (int t : test)
        {
            System.out.println(t);
            System.out.println(a.perform(t));  
            System.out.println(b.perform(t));  
            System.out.println(c.perform(t));  
        }
    }

    private static PerformOperaton isOdd()
    {
        return i -> ( (i % 2 == 1) ? "odd" : "even" );
    }

    private static PerformOperaton isPrime()
    {
        return i -> ( (BigInteger.valueOf(i).isProbablePrime(1000000)) ? "prime" : "nope" );
    }

    private static PerformOperaton isPalindrome()
    {
        return i ->
        {
            if (i == 0) return "palindrome";
            
            ArrayList<Integer> digs = new ArrayList<>();
            while (i > 0)
            {
                digs.add(i % 10);
                i = i / 10;
            }
            
            int b = 0, e = digs.size() - 1;
            while (b < e)
            {
                if (digs.get(b++) != digs.get(e--))
                    return "nope";
            }
            
            return "palindrome";
        };
    }

}
