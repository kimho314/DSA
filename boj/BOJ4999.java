package boj;

public class BOJ4999 {
    static FastReader SC = new FastReader();
    static String STR1, STR2;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int len1 = STR1.length();
        int len2 = STR2.length();

        if (len1 >= len2) {
            System.out.println("go");
        }
        else {
            System.out.println("no");
        }
    }

    private static void input() {
        STR1 = SC.nextLine();
        STR2 = SC.nextLine();
    }
}
