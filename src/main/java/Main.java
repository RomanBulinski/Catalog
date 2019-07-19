import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static String change(String input) {
        return input.replaceAll("<prod><name>","")
                .replaceAll("</name><prx>"," > prx: \\$")
                .replaceAll("</prx><qty>"," qty: ")
                .replaceAll("</qty></prod>","");
    }

    public static String catalog(String s, String article) {
        String[] lines = s.split("\n\n");
        String result = Arrays.asList(lines).stream()
                .filter(n -> n.contains(article))
                .map(j -> change(j))
                .collect(Collectors.joining("\n"));
        if(result.equals("")){
            result = "Nothing";
        }
        return result;
    }
    

}
