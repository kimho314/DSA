package boj;

public class BOJ1225 {
    private static FastReader SC = new FastReader();
    private static String A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long sum = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                sum += (long) (A.charAt(i) - '0') * (long) (B.charAt(j) - '0');
            }
        }

        System.out.println(sum);
    }

    private static void input() {
        A = SC.next();
        B = SC.next();
    }
}
