public class areaCalculator {
    public static double area (double radius) {
        if (radius >= 0) {
            double areaCircle = (radius * radius * Math.PI);
            return areaCircle;
        } else {
            return -1;
        }
    }

    public static double area (double x, double y) {
        if (x < 0 || y < 0) {
            return -1;
        } else {
            double areaReg = x * y;
            return areaReg;
        }
    }
}
