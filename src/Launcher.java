import java.util.*;

public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Hello World ! Type in your command: ");
        List<Command> C = List.of(new Quit(), new Fibo(), new Freq());
        Scanner sc = new Scanner( System.in );
        String c = sc.nextLine();
        int i;
        for (i = 0; i < C.size(); i++)
        {
            if (C.get(i).Name().equals(c))
            {
                C.get(i).Run(sc);
                if (C.get(i).Run(sc))
                {
                    break;
                }
            }
            else if (i+1 == C.size())
            {
                System.out.println("Unknown Command. Type again");
                c = sc.nextLine();
                i = 0;
            }
        }
        System.exit(0);
    }
}
