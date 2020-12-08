package dec07a;
import java.util.*;

/**
 * @author F. Ulstack
 * 
 * Print triangles
 */

class Triangle
{
    char arr[][];
    
    public Triangle()
    {
        arr = new char[5][];
        for (int i = 0; i < 5; i++)
        {
            arr[i] = new char[5];
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
            int i = 0, j = row.length - 1;
            while (i != j)
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
        while (i != j)
        {
            char tmpRow[] = arr[i];
            arr[i] = arr[j];
            arr[j] = tmpRow;
            i++; j--;
        }
    }
}

public class Dec07A
{
    private static ArrayList<ArrayList<String>> mybuf = new ArrayList<>();

    public static void main(String[] args)
    {
        Triangle tr = new Triangle();
        
        prepare(1, tr, 0, 0);

        tr.flipVert();
        prepare(2, tr, 0, 0);
        
        Triangle tr2 = new Triangle();
        prepare(3, tr, 0, 0);
        prepare(3, tr2, 0, 5);

        tr.flipHoriz();
        tr2.flipHoriz();
        prepare(4, tr, 0, 0);
        prepare(4, tr2, 0, 5);

        for (ArrayList<String> lst : mybuf)
        {
            for (String string : lst)
            {
                System.out.println(string);
            }
        }
    }

    // prepping all parts
    private static void prepare(int row, Triangle tr, int y, int x)
    {
        // prep add
        if (row - 1 == mybuf.size())
        {
            ArrayList<String> cur = new ArrayList<>();
            
            cur.add(row + ")");
            
            for (int i = 1; i < y; i++)
            {
                cur.add("");                
            }
            
            String filr = null;
            if (x > 0)
            {
                char temp[] = new char[x];
                Arrays.fill(temp, ' ');
                filr = new String(filr);
            }
            
            for (char[] trRow : tr.arr)
            {
                String prn = (filr != null) ? filr + new String(trRow) : new String(trRow);
                cur.add(prn);
            }

            char temp[] = new char[9];
            Arrays.fill(temp, '-');
            cur.add(new String(temp));
            
            mybuf.add(cur);
        }
        // prep replace
        else if (row == mybuf.size())
        {
            for (int i = 1; i < 6; i++)
            {
                ArrayList<Character> temp = new ArrayList<>();
                char[] trRow = tr.arr[i-1];
                for (char c : trRow)
                    temp.add(c);
                
                for (int j = temp.size(); j < x + trRow.length; j++)
                    temp.add(' ');
 
                for (int j = 0; j < trRow.length; j++)
                {
                    temp.set(x + j, trRow[j]);
                }
                
                StringBuilder sb = new StringBuilder();
                for (Character ch : temp) sb.append(ch);
                mybuf.get(row - 1).set(i, sb.toString());
            }
        }
        else
            throw new IllegalArgumentException("bad row");
        
    }
}
