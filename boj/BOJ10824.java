package boj;

public class BOJ10824 {
    static FastReader SC = new FastReader();
    static String A, B, C, D;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long num1 = Long.parseLong(A + B);
        long num2 = Long.parseLong(C + D);
        System.out.println(num1 + num2);
    }

    private static void input() {
        A = SC.next();
        B = SC.next();
        C = SC.next();
        D = SC.next();
    }
}
