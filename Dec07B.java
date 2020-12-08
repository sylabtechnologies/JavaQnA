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
    public static void info()
    {
        System.out.println("Guess the number between 1 and 1000:");
        System.out.println("");
    }    
    
    public static void main(String[] args)
    {
        info();
        
        Random rand = new Random();
        int mustguess = rand.nextInt(1000) + 1;

        Scanner input = new Scanner(System.in);
        int guess = 0;

        while(true)
        {
            System.out.print("Your guess? ");
            guess = input.nextInt();
            
            if (Math.abs(guess - mustguess) <= 100)
                break;
            else if(guess > mustguess)
            {
                System.out.println("It\'s lower.");
            }
            else
            {
                System.out.println("It\'s higher.");
            }
        }

        System.out.println("Nice job!");
        System.out.println("Your number is: " + mustguess);
    }
}
