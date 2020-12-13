package dec11singleton;

/**
 * @author F. Ulstak
 * a koolkat
 */

public class Singleton
{
    public String value = "mygear";
    private static volatile Singleton instance = null;    
    
    public static Singleton getInstance()
    {
        if (instance == null)
        {
            synchronized(Singleton.class)
            {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        
        return instance;
        
    }
    
    private Singleton() {};
}