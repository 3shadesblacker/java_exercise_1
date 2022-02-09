import java.util.*;

public class Launcher
{
    public static void main(String[] args)
    {
        List<Command> C = List.of(new Quit(), new Fibo(), new Freq());
        System.out.println("Enter a command or be doomed !");
        Scanner sc = new Scanner( System.in );
        String c = sc.nextLine();
        int i = 0;
        do{
            if (C.get(i).Name().equals(c))
            {
                if (C.get(i).Run(sc)) 
                {
                    sc.close();
                    break;
                }
            }
            else if ( i == C.size() - 1){
                System.out.println("Command wasn't found.");
            }
            else
                i++;
            c = sc.nextLine();
        }while (!C.get(i).Run(sc));
    }
}
