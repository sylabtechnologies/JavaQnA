package dec12lambdaa;

import java.util.Arrays;

// lambda A
public class Dec12LambdaA
{
    public static void main(String[] args)
    {
        String[] weather = { "sunny", "showers", "thunderstorm", "cool", "cloudy", "excellent"};
        Arrays.sort(weather, (s1, s2)->Integer.compare(s1.length(), s2.length()));
        System.out.println(Arrays.toString(weather));
        
        Arrays.sort(weather, (s1, s2)->Integer.compare(s2.length(), s1.length()));
        System.out.println(Arrays.toString(weather));

        Arrays.sort(weather, (s1, s2)->Integer.compare(s1.charAt(0), s2.charAt(0)));
        System.out.println(Arrays.toString(weather));
        
        Arrays.sort(weather, (s1, s2)->
        {
            boolean test1 = s1.charAt(0) == 'e';
            boolean test2 = s2.charAt(0) == 'e';
            
            if (test1 && !test2) return -1;
            if (test2 && !test1) return 1;
            return 0;            
        });
        System.out.println(Arrays.toString(weather));
    }
}
