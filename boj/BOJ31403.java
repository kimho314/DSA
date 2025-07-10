package boj;

public class BOJ31403 {
    static FastReader SC = new FastReader();
    static String A, B, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);
        System.out.println(a + b - c);

        String ab = A + B;
        int res = Integer.parseInt(ab) - Integer.parseInt(C);
        System.out.println(res);
    }

    private static void input() {
        A = SC.next();
        B = SC.next();
        C = SC.next();
    }
}
