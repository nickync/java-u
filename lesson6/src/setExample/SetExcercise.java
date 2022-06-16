package setExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExcercise {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<String>();

        numbers.add("1");
        numbers.add("1");
        numbers.add("2");

        Set<String> uniqueNumbers = new HashSet<String>(numbers);

        for (String num: uniqueNumbers) {
            System.out.println(num);
        }

    }
}
