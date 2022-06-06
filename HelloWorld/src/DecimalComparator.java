public class DecimalComparator {
    // check to see if 3 decimals are two numbers are equal
    public static boolean areEqualByThreeDecimalPlaces (double a, double b) {
        a = (int) (a * 1000);
        b = (int) (b * 1000);
        if (a==b) {
            return true;
        } else {
            return false;
        }
    }
}
