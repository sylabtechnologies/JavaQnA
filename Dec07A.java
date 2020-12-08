package dec07a;
import java.util.*;

/**
 * @author F. Ulstack
 * 
 * Print triangles
 */

class Triangle
{
    private int mySize = 5;
    char arr[][];
    
    public Triangle(int sz)
    {
        mySize = sz;
        
        arr = new char[mySize][];
        for (int i = 0; i < mySize; i++)
        {
            arr[i] = new char[mySize];
            Arrays.fill(arr[i], ' ');
            
            for (int j = 0; j < i+1; j++)
            {
                arr[i][j] = '*';                
            }
        }
    }

    void flipVert()
    {
        for (char[] row : arr)
        {
            int i = 0, j = mySize - 1;
            while (i <= j)
            {
                char tmp = row[i];
                row[i] = row[j];
                row[j] = tmp;
                i++; j--;
            }
        }
    }

    void flipHoriz()
    {
        int i = 0, j = arr.length - 1;
        while (i <= j)
        {
            char tmpRow[] = arr[i];
            arr[i] = arr[j];
            arr[j] = tmpRow;
            i++; j--;
        }
    }

    public int getSize() {
        return mySize;
    }
    
}

public class Dec07A
{
    private static ArrayList<ArrayList<String>> mybuf = new ArrayList<>();

    public static void main(String[] args)
    {
        Triangle tr = new Triangle(4);
        
        prepare(1, tr, 0, 0);

        tr.flipVert();
        prepare(2, tr, 0, 0);
        
        Triangle tr2 = new Triangle(4);
        prepare(3, tr, 0, 1);
        prepare(3, tr2, 0, 4);

        tr.flipHoriz();
        tr2.flipHoriz();
        prepare(4, tr, 0, 1);
        prepare(4, tr2, 0, 4);

        for (ArrayList<String> lst : mybuf)
        {
            for (String string : lst)
            {
                System.out.println(string);
            }
        }
    }

    // prepping all parts
    private static void prepare(int row, Triangle tr, int ystart, int xstart)
    {
        // prep add
        if (row - 1 == mybuf.size())
        {
            ArrayList<String> cur = new ArrayList<>();
            
            cur.add(row + ")");
            
            for (int i = 1; i < ystart; i++)
            {
                cur.add("");                
            }
            
            String filr = null;
            if (xstart > 0)
            {
                char temp[] = new char[xstart];
                Arrays.fill(temp, ' ');
                filr = new String(temp);
            }
            
            for (char[] trRow : tr.arr)
            {
                String prn = (filr != null) ? filr + new String(trRow) : new String(trRow);
                cur.add(prn);
            }

            char temp[] = new char[tr.getSize() * 2 + 1];
            Arrays.fill(temp, '-');
            cur.add(new String(temp));
            
            mybuf.add(cur);
        }
        // prep replace
        else if (row == mybuf.size())
        {
            for (int i = 1; i < tr.getSize() + 1; i++)
            {
                String cur = mybuf.get(row-1).get(i);
                ArrayList<Character> temp = new ArrayList<>();
                for (char c : cur.toCharArray())
                    temp.add(c);
                
                char[] trRow = tr.arr[i-1];
                for (int j = temp.size(); j < xstart + trRow.length; j++)
                    temp.add(' ');
                
                for (int j = xstart; j < xstart + trRow.length; j++)
                    temp.set(j, trRow[j-xstart]);
 
                StringBuilder sb = new StringBuilder();
                for (Character ch : temp) sb.append(ch);
                mybuf.get(row - 1).set(i, sb.toString());
            }
        }
        else
            throw new IllegalArgumentException("bad row");
        
    }
}
