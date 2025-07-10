package boj;

public class BOJ2057 {
    private static FastReader SC = new FastReader();
    private static long N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long[] factorials = new long[21];
        factorials[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        if (N == 0) {
            System.out.println("NO");
            return;
        }

        long num = N;
        for (int i = 20; i >= 0; i--) {
            if (num >= factorials[i]) {
                num -= factorials[i];
            }
        }

        if (num == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    private static void input() {
        N = SC.nextLong();
    }
}
