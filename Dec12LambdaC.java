package dec12lambdac;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// #C
public class Dec12LambdaC
{
    public static void main(String[] args)
    {
        String[] tst = { "aaa", "abc", "dcde", "add", "bam", "wam"};
        List<String> test = new ArrayList<>(Arrays.asList(tst));
        
        System.out.println(test);
        System.out.println(lambdaC(test));
    }

    private static List<String> lambdaC(List<String> test)
    {
        List<String> ret = new ArrayList<>();
        test.stream().filter(s-> (s.length() == 3 && s.charAt(0) == 'a')).collect(Collectors.toCollection(() -> ret));;
        return ret;
    }
}
