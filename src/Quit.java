import java.util.Scanner;

public class Quit implements Command
{
    @Override
    public String Name()
    {
        return "quit";
    }

    @Override
    public boolean Run(Scanner s)
    {
        System.out.println("Goodbye.");
        return true;
    }
}