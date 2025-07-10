package boj;

public class BOJ11561 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static long[] N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            long steps = findMaxSteppingStones(N[i]);
            sb.append(steps).append('\n');
        }

        System.out.println(sb);
    }

    private static long findMaxSteppingStones(long n) {
        long result = 0;
        long l = 1;
        long r = 1_000_000_000L;
        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = (mid * (mid + 1)) / 2;
            if (sum <= n) {
                result = Math.max(result, mid);
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static void input() {
        T = SC.nextInt();
        N = new long[T];
        for (int i = 0; i < T; i++) {
            N[i] = SC.nextLong();
        }
    }
}
