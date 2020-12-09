package dec08b;

import java.util.Random;
import java.util.Arrays;

/**
 * @author F. Ulstack
 * 
 * find max number
 */

public class Dec08B
{
    private final static int NROWS = 10;
    private final static int NCOLS = 10;
    private final static int MAXNUM = 100;
    
    public static void main(String[] args)
    {
        int arr[][] = new int[NROWS][NCOLS];

        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            int[] row = arr[i];
            for (int j = 0; j < row.length; j++){
                row[j] = rand.nextInt(MAXNUM) + 1;
            }
            
            System.out.println(Arrays.toString(row));
        }

        int max = Integer.MIN_VALUE, maxi = -1, maxj = -1;
        for (int i = 0; i < arr.length; i++)
        {
            int[] row = arr[i];
            for (int j = 0; j < row.length; j++)
            {
                if (row[j] > max)
                {
                    max = row[j];
                    maxi = i; maxj = j;
                }
            }
        }
        
        System.out.println("max = (" + maxi + ", " + maxj + ")");
        
    }
    
}
