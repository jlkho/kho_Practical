
package kho_practical;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Kho_practical {

 public static void wordMatch(String str, String theRegex, String identifier) {
        String pattern = theRegex;
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        while (m.find()) {
            if (m.group().length() != 0) {
                System.out.println(m.group() + " is " + identifier+"\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader("input.txt"));
            while (sc.hasNext()) {
                String token = sc.next();
                System.out.println("Token: " + token);
                wordMatch(token, "[a-zA-Z]*", "ID");
                wordMatch(token, "[-]", "MINUS");
                wordMatch(token, "[+]", "PLUS");
                wordMatch(token, "[*]", "TIMES");
                wordMatch(token, "[/]", "DIVIDE");
                wordMatch(token, "[=]", "ASSIGN");
                wordMatch(token, "[;]", "SEMI");
                wordMatch(token, "[0-9]*", "NUM");
                wordMatch(token, "[(]", "LPAREN");
                wordMatch(token, "[)]", "RPAREN");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Kho_practical.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}