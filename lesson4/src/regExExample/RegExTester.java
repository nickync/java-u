package regExExample;

import java.util.regex.Pattern;

public class RegExTester {
    public static void main(String[] args) {
        String emailRegEx = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegEx);
        String email = "jeff@gmail.com";

        System.out.println(pattern.matcher(email).matches());
    }
}
