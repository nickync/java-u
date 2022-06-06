public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays (long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            int year =(int) ((minutes / (60 * 24)) / 365);
            int day =(int) (minutes / (60 * 24)) % 365;
            System.out.println(minutes + "min = " + year + " y " + day + " d");

        }
    }
}

// declared void status, no return statement needed
