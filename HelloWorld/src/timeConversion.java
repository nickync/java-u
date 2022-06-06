public class timeConversion {
    public static int getDurationString (int minutes, int seconds) {
        if (minutes >= 0 && seconds <= 59 && seconds >= 0) {
            int totalSeconds = minutes * 60 + seconds;
            int hour = totalSeconds / 3600;
            int rem_minutes = (totalSeconds % 3600) / 60;
            int rem_seconds = (rem_minutes / 60) % 60;
            System.out.println(hour + "h " + rem_minutes + "m " + seconds + "s");
            return 1;
        } else {
            System.out.println("Invalid value");
            return -1;
        }
    }

    public static int getDurationString (int seconds) {
        if (seconds >= 0) {
            int hour = (seconds / 3600);
            int minute = (seconds % 3600) / 60;
            int second = seconds - hour*3600 - minute*60;
            System.out.println(hour + "h " + minute + "m " + second + "s");
            return 1;
        } else {
            return -1;
        }
    }
}
