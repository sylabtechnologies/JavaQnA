package dec12lambdab;

// #B
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Dec12LambdaB
{
    public static void main(String[] args)
    {
        List<Integer> test = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(lambdaC(test));
    }

    private static String lambdaC(List<Integer> test)
    {
        StringBuilder sb = new StringBuilder();

        test.forEach((val)->{
            sb.append((val %2 == 0 ? "e" : "o") + val + ",");
        });        

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
