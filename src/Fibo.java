import java.util.Scanner;

public class Fibo implements Command
{
    @Override
    public String Name()
    {
        return "fibo";
    }

    @Override
    public boolean Run(Scanner s)
    {
        int n;
        System.out.println("Type the index value: ");
        n = s.nextInt();
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
        return false;
    }
}