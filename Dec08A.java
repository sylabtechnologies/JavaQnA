package dec08a;

/**
 * @author F. Ulstack
 * 
 * add command args
 */

public class Dec08A {

    public static void main(String[] args)
    {
        int sum = 0;
        
        if (args.length == 0) {
            System.out.println("Enter numbers on command line");
            return;
        }
        
        for (String a : args) {
            
            try {
                sum += Integer.parseInt(a);
            }
            catch (NumberFormatException e) {
                System.out.println("skipping " + a);
            }
            
        }
        
        System.out.println("You entered " + sum);
        
    }
}
