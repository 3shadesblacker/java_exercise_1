import java.util.Scanner;

public interface Command
{
    String Name();
    boolean Run(Scanner s);
}