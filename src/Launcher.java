import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Hello World ! Type in your command: ");
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();
        while (!s.equals("quit"))
        {
            if (s.equals("fibo"))
            {
                int n;
                System.out.println("Type the index value: ");
                n = sc.nextInt();
                if (n == 0 || n == 1)
                {
                    System.out.println(n);
                }
                else
                {
                    int a = 0, b = 1, c = a + b;
                    for (int i = 2; i < n; i++)
                    {
                        a = b;
                        b = c;
                        c = a + b;
                    }
                    System.out.println(c);
                }
            }
            else if (s.equals("freq"))
            {
                System.out.println("Type in the path to your file: ");
                Path p = Path.of(sc.nextLine());
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
                    int a = 0, b = 0, c = 0;
                    for (Map.Entry<String, Integer> me : set)
                    {
                        if (me.getValue() > a)
                        {
                            a = me.getValue();
                            c = b; C = B;
                            b = a; B = A;
                            A = me.getKey();
                        }
                        else if (me.getValue() > b)
                        {
                            b = me.getValue();
                            c = b; C = B;
                            B = me.getKey();
                        }
                        else
                        {
                            c = me.getValue();
                            C = me.getKey();
                        }
                    }
                    System.out.println("1. " + A + " 2. " + B + " 3. " + C);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Type in your command: ");
            }
            s = sc.nextLine();
        }
        System.exit(0);
    }
}
