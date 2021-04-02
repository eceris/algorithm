package eceris.goorm;

public class LeapYear {
    public static void main(String[] args) {
        boolean leap = isLeap(2000);
        String isLeap = leap ? "Leap Year" : "Not Leap Year";
        System.out.println(isLeap);
    }

    static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                return false;
            }
            return true;
        }

        return false;
    }
}
