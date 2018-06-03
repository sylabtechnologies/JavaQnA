// v2. use integer points i = x*100 for robustness

/**
 * @author D/R, 6/4/2018
 */

/* Assume all points are different
 * Q: from 137 circle points, find one that isnt listed clockwise
 * (x,y) positions of the points are rounded to 2 decimal places.
 * A: Use cross product
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidObjectException;
import java.util.Scanner;
import java.lang.Math;

public class CirclePoints {
    
    public static final int MySize = 137;

    public static void main(String[] args) {
        
        int[] point_id = new int[MySize];
        int[] x_coord  = new int[MySize];
        int[] y_coord  = new int[MySize];
        
        // String myfilename = "points.csv";
        String myfilename = "circle.csv";
        File myfile = new File(myfilename);
        
        try {
            
            Scanner scan = new Scanner(myfile);

            int i = 0;
            while (scan.hasNext() && i < MySize) {
                
                String data = scan.nextLine();
                String fields[] = data.split(",");
                if (fields.length != 3) throw new java.io.InvalidObjectException("bad line");

                point_id[i] = Integer.parseInt(fields[0]);
                Float x = (Float.parseFloat(fields[1]))*100.0f;
                Float y  = (Float.parseFloat(fields[2]))*100.0f;
                // truncate to integer points as x100
                x_coord[i] = x.intValue();
                y_coord[i] = y.intValue();
                
                i++;
            }

            // compute the cross product
            for (i = 0; i < MySize - 1; i++) {

                int dx = x_coord[i+1] - x_coord[i];
                int dy = y_coord[i+1] - y_coord[i];
                int prod = x_coord[i]*dy - y_coord[i]*dx;

                if (prod >= 0) {
                    System.out.printf(" Edge (%d, %d) : ", point_id[i], point_id[i+1]);
                    System.out.printf(" Cross product %d\n", prod);
                }
            }
           
            scan.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InvalidObjectException e)
        {
            e.printStackTrace();
        }
    }
    
}
