package boj;

public class BOJ27961 {
    static FastReader SC = new FastReader();
    static long N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int result = (int) (Math.log(N) / Math.log(2));
        if (Math.pow(2, result) <= N) {
            result += 1;
        }
        System.out.println(result + 1);
    }

    private static void input() {
        N = SC.nextLong();
    }
}
