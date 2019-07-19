import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {


//"table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\n..."

    static String sTemp = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>\n\n" +
            "<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>\n\n" +
            "<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>\n\n" +
            "<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>\n\n" +
            "<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>";

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
        return result;
    }




    public static void main(String[] args) {
        System.out.println(catalog(sTemp, "saw"));
    }


}
