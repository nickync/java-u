import java.util.List;

public class Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        getOddNumbers(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "API", "Microservices", "Azure", "Docker");
        courses.forEach(System.out::println);
        System.out.println("*********************");
        courses.stream().filter(i -> i.contains("Spring")).forEach(System.out::println);
        System.out.println("---------------------");
        courses.stream().filter(i -> i.length() >= 4).forEach(System.out::println);
        System.out.println("cubes");
        numbers.stream().filter(i -> i % 2 != 0).map(i -> i*i*i).forEach(System.out::println);

    }

    public static void getOddNumbers(List<Integer> numbers){
        numbers.stream()
                .filter(i -> i % 2 != 0)
                .forEach(System.out::println);
    }


}
