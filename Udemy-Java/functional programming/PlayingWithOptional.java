import java.util.List;
import java.util.function.Predicate;

public class PlayingWithOptional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "mango");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
        fruits.stream().filter(predicate).forEach(System.out::println);
    }
}
