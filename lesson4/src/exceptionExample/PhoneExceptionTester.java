package exceptionExample;

public class PhoneExceptionTester {
    public static void main(String[] args) {
        String[] numbers = new String[] {"123-4567", null, "323", "3452"};
        for (int i=0; i<numbers.length; i++) {
            try {
                System.out.println(new Phone("iPhone", numbers[i]));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
}
