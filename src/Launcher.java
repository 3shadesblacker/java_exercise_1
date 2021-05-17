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
            System.out.println("Unknown command. Try again: ");
            s = sc.nextLine();
        }
        System.exit(0);
    }
}
