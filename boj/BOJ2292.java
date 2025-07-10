package boj;

public class BOJ2292 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int count = 1;
        int range = 2;

        if (N == 1) {
            System.out.println(1);
            return;
        }
        while (range <= N) {
            range = range + (6 * count);
            count++;
        }
        System.out.println(count);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
