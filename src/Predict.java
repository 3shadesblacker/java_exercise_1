import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Predict implements Command{
    @Override
    public String Name()
    {
        return "predict";
    }

    @Override
    public boolean Run(Scanner s)
    {
        System.out.println("Type in the path to your file: ");
        Path p = Path.of(s.nextLine());
        try
        {
            String P = Files.readString(p);
            String[] S = P.split(" ");
            HashMap<String, List<String>> h = new HashMap<String, List<String>>();
            for (int i = 0; i < S.length; i++)
            {
                if (h.containsKey(S[i])){
                    if (!S[i].substring(S[i].length()-1).equals("."))
                    {
                        List<String> S2 = h.get(S[i]);
                        S2.add(S[i+1]);
                        h.put(S[i], S2);
                    }
                    else
                    {
                        List<String> S2 = Arrays.asList(S[i]);
                        h.put(S[i], S2);
                    }
                }
                else{
                    if (!S[i].substring(S[i].length()-1).equals("."))
                    {
                        List<String> S2 = Arrays.asList(new String[] {});
                        S2.add(S[i+1]);
                        h.put(S[i], S2);
                    }
                    else
                    {
                        List<String> S2 = Arrays.asList(S[i]);
                        h.put(S[i], S2);
                    }
                }
            }
            HashMap<String, String> h2 = new HashMap<String, String>();
            for (Map.Entry<String, List<String>> i : h.entrySet()){
                int occ = 0; String w = "";
                for (String j : i.getValue()){
                    int k = Collections.frequency(i.getValue(), j);
                    if ( k > occ){
                        w = j;
                        occ = k;
                    }
                }
                h2.put(i.getKey(), w);
            }
            System.out.println("Enter a word: ");
            String word = s.nextLine();
            boolean found = false;
            for (Map.Entry<String, String> i : h2.entrySet()){
                if (i.getKey().equals(word)){
                    found = true;
                    break;
                }
            }
            if (found){
                int count = 0;
                for (; count == 20 || word.substring(word.length()-1).equals("."); count++){
                    System.out.print(word+" ");
                    word = h2.get(word);
                }
                System.out.println(word);
            }
            else{
                System.out.println("This word isn't present in the dictionnary.");
            }
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