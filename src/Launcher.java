import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Hello World ! Type in your command: ");
        Scanner sc = new Scanner( System.in );
        String s = sc.nextLine();/*
        if (s.equals("quit"))
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Unknown command");
        }*/
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
                s = sc.nextLine();
            }
            else
            {
                System.out.println("Type in your command: ");
                s = sc.nextLine();
            }
        }
        System.exit(0);
    }
}
