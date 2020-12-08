/**
 * @author D/R
 * Q: Unscramble image given scramble map
 * A: Use the map
 */

import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Unscramble {

    public static void main(String[] args) {
        
        // open image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("mystery.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        int my_w = img.getWidth();
        int my_h = img.getHeight();
        System.out.printf("%d x %d pixels\n", my_w, my_h);

        // load shuffle indices
        String myfilename = "shuffle.txt";
        File myfile = new File(myfilename);
        int[] shuffle = new int[my_w*my_h];

        try
        {
            Scanner scan = new Scanner(myfile);

            int i = 0;
            while (scan.hasNext()) {
                shuffle[i] = scan.nextInt();
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
      
        System.out.printf("%d shuffles\n", shuffle.length);
        
        // unshuffle
        BufferedImage result = new BufferedImage(my_w, my_h, BufferedImage.TYPE_INT_RGB);
        
        for (int i = 0; i < shuffle.length; i++) {
            
            int x = get_xcoord(my_w, i);
            int y = get_ycoord(my_w, i);
            int pixel = img.getRGB(x, y);
            
            x = get_xcoord(my_w, shuffle[i]);
            y = get_ycoord(my_w, shuffle[i]);
            result.setRGB(x, y, pixel);
        }
       
        // write
        try
        {
            File outfile = new File("revealed.jpg");
            ImageIO.write(result, "jpg", outfile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       
    }
    
    private static int get_xcoord(int width, int flat_index) {
        return ( flat_index % width );
    }
    
    private static int get_ycoord(int width, int flat_index) {
        return ( flat_index / width );
    }
}
