https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value/40501

package javapassbyvalue;

import java.util.*;

public class JavaPassByValue {

    public static void main(String[] args) {
        
        Dog aDog = new Dog("Gromit");
        
        test(aDog);
        
        // we still pointing to Gromit the dog
        System.out.println("Is it Gromit: " + aDog.getName().equals("Gromit"));
        System.out.println("Is it Philip: " + aDog.getName().equals("Philip"));
    }

    public static void test(Dog d) {
        System.out.println("test Dog: " + d.getName());
        // change d inside to point to a new Dog instance
        // we must use setDog for that
        d = new Dog("Philip");
        System.out.println("To: " + d.getName());
    }

    
}
