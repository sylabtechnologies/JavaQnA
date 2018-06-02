package unscrambleui;

import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author D/R/py 6/1/18
 */

public class UnscrambleUI extends JPanel {

    public static String inputFilename;
    
    public static int imageWidth  = 592; 
    public static int imageHeight = 480;
    public static int imageBorder = 20;
    
    public void paint(Graphics g) {

        Image myimage = readFile();

        g.drawImage(myimage, imageBorder, imageBorder, this);
    }

    private Image readFile() {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(inputFilename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        ShowInfo.infoBox(String.format("%d x %d pixels", img.getWidth(), img.getHeight()), inputFilename);

        return img;
    }

    public static void main(String[] args) {

        if (args.length == 1)
            inputFilename = args[0];
        else
            return;
        
        JFrame frame = new JFrame();
        frame.getContentPane().add(new UnscrambleUI());
  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(imageWidth + 2*imageBorder, imageHeight + 2*imageBorder);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        
    }
    
}
