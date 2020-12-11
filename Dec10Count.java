package dec10count;
import java.io.IOException;
import java.nio.file.*;

/**
 * @author F. Ulstak
 * count a char 
 */

public class Dec10Count
{

    /**
     * @param file char
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2 || args[1].length() != 1)
        {
            System.out.println("Dec10Count file char");
            return;
        }

        Path testFile = Paths.get(args[0]);
        if (!Files.exists(testFile, LinkOption.NOFOLLOW_LINKS) || !Files.isRegularFile(testFile, LinkOption.NOFOLLOW_LINKS))
        {
            System.out.println("provide a file");
            return;
        }
        
        byte bytes[] = Files.readAllBytes(testFile);
        byte test = args[1].getBytes()[0];

        int count = 0;
        for (byte b : bytes)
        {
            if (b == test) count++;
        }
        
        System.out.println(count + " char(s)");
    }
    
}

