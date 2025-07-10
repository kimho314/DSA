package boj;

public class BOJ2753 {
    private static FastReader SC = new FastReader();
    private static int YEAR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean isLeapYear = (YEAR % 4 == 0 && YEAR % 100 != 0) || YEAR % 400 == 0;
        System.out.println(isLeapYear ? 1 : 0);
    }

    private static void input() {
        YEAR = SC.nextInt();
    }
}
