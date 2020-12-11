package dec10append;
import java.io.IOException;
import java.nio.file.*;

/**
 * @author F. Ulstak
 * Dec10Append file text
 */

public class Dec10Append {

    /**
     * @param file word1 word2 word3 
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length < 2)
        {
            System.out.println("Dec10Append file word(s)");
            return;
        }
        
        Path testFile = Paths.get(args[0]);
        if (Files.exists(testFile, LinkOption.NOFOLLOW_LINKS) && !Files.isRegularFile(testFile, LinkOption.NOFOLLOW_LINKS))
        {
            System.out.println("provide a file");
            return;
        }
        
        for (int i = 1; i < args.length; i++)
        {
            String arg = args[i];
            Files.write(testFile, new String(arg + " ").getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
    
}
