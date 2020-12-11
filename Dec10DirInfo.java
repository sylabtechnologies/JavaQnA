package dec10dirinfo;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.Map;

/**
 * @author F. Ulstak
 * dirinfo
 */

public class Dec10DirInfo {

    /**
     * @param dir
     */
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1)
        {
            System.out.println("Dec10DirInfo dir");
            return;
        }
        
        Path testFile = Paths.get(args[0]);
        if (!Files.isDirectory(testFile, LinkOption.NOFOLLOW_LINKS))
        {
            System.out.println("Dec10DirInfo dir");
            return;
        }

        DirectoryStream<Path> stream = Files.newDirectoryStream(testFile);
        for (Path path : stream)
        {        
            System.out.println(path.getFileName());
        }
        
    }
    
}

