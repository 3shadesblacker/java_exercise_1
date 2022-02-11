import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Freq implements Command
{
    @Override
    public String Name()
    {
        return "freq";
    }

    @Override
    public boolean Run(Scanner s)
    {
        // getting the tree most used words in a file
        System.out.println("Type in the path to your file: ");
        Path p = Path.of(s.nextLine());
        try
        {
            String P = Files.readString(p);
            String[] S = P.split(" ");
            HashMap<String, Integer> h = new HashMap<>();
            for (int i = 0; i < S.length; i++)
            {
                if (h.containsKey(S[i]))
                { h.put(S[i], h.get(S[i]) + 1); }
                else
                { h.put(S[i], 1); }
            }
            Set<Map.Entry<String, Integer> > set = h.entrySet();
            String A = "", B = "", C = "";
            int a = 0, b = 0;
            for (Map.Entry<String, Integer> me : set)
            {
                if (me.getValue() > a)
                {
                    C = B;
                    b = a; B = A;
                    a = me.getValue();
                    A = me.getKey();
                }
                else if (me.getValue() > b)
                {
                    C = B;
                    b = me.getValue();
                    B = me.getKey();
                }
                else
                {
                    C = me.getKey();
                }
            }
            System.out.println("1. " + A + " 2. " + B + " 3. " + C);
        }
        catch (IOException e)
        {
            System.out.println("Unreadable file: ");
            System.out.println(e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
        }
        return false;
    }
}
