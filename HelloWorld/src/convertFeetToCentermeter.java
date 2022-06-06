public class convertFeetToCentermeter {
    public static double calcFeetAndInchesToCentimers(int feet, int inches) {
        if (feet < 0 || inches > 12) {
            return -1;
        } else {
            double cm = ((feet * 12 + inches) * 2.54d);
            return cm;
        }
    }

    public static double calcFeetAndInchesToCentimers (int inches) {
        if (inches >= 0) {
            double feet = ((double) inches / 12);
            return feet;
        } else {
            return -1;
        }
    }
}
