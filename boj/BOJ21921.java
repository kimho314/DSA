package boj;

public class BOJ21921 {
    private static FastReader SC = new FastReader();
    private static int N, X;
    private static int[] VISITORS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int l = 0, r = 0;
        long max = 0;
        int res = 0;
        int cnt = 0;
        long prev = 0;

        for (l = 0; l < N - X + 1; l++) {
            long sum = prev;
            if (l > 0) {
                cnt--;
                sum -= VISITORS[l - 1];
            }

            while (r < N && cnt < X) {
                sum += VISITORS[r];
                r++;
                cnt++;
            }
            prev = sum;
            // System.out.println(l + " " + r + " " + cnt + " " + sum);
            if (max == sum) {
                res++;
                continue;
            }
            if (max < sum) {
                max = sum;
                res = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(res);
        }
    }

    private static void input() {
        N = SC.nextInt();
        X = SC.nextInt();
        VISITORS = new int[N];
        for (int i = 0; i < N; i++) {
            VISITORS[i] = SC.nextInt();
        }
    }
}
