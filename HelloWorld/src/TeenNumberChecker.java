public class TeenNumberChecker {
    public static boolean hasTeen(int a, int b, int c) {
        if (a >= 13 && a <= 19) {
            return true;
        } else if (b >= 13 && b <= 19){
            return true;
        } else if (c >= 13 && c <= 19){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isTeen(int a) {
        if (a >= 13 && a <= 19) {
            return true;
        } else {
            return false;
        }
    }

}

