package dec07b;
import java.util.Scanner;
import java.util.Random;

/**
 * @author F. Ulstak
 * 
 * Guess the number
 */

public class Dec07B
{
    private final static int MAXNUM = 100;
    
    public static void info()
    {
        System.out.println("Guess the number between 1 and " + MAXNUM + ":");
        System.out.println("");
    }    
    
    public static void main(String[] args)
    {
        info();
        
        Random rand = new Random();
        int mustguess = rand.nextInt(MAXNUM) + 1;

        Scanner input = new Scanner(System.in);
        int guess = 0, cnt = 0;
        boolean found = false;

        while(!found && cnt < 5)
        {
            System.out.print("Your guess? ");
            guess = input.nextInt();
            
            if (Math.abs(guess - mustguess) <= 10)
            {
                found = true;
                continue;
            }
            
            cnt++;
            if(guess > mustguess)
                System.out.println("It\'s lower.");
            else
                System.out.println("It\'s higher.");
        }

        if (found)
            System.out.print("Nice job! ");
        else
            System.out.println("Sorry!");
            
        System.out.print("Your number is: " + mustguess);
    }
}
