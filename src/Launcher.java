import java.util.*;

public class Launcher
{
    public static void main(String[] args)
    {
        Command[] C = {new Quit(), new Fibo(), new Freq(), new Predict()};
        System.out.println("Enter a command:");
        Scanner sc = new Scanner( System.in );
        String cmd = sc.nextLine();
        do{
            // fibo
            if(cmd.equals(C[1].Name()))
                C[1].Run(sc);
            // freq
            else if(cmd.equals(C[2].Name()))
                C[2].Run(sc);
            // predict
            else if(cmd.equals(C[3].Name()))
                C[2].Run(sc);
            // unknown command
            else
                System.out.println("Unknown Command");
            // asking for a new command
            System.out.println("Enter a command:");
            cmd = sc.nextLine();
        }while(!cmd.equals(C[0].Name()));
        sc.close();
        System.exit(0);
    }
}
