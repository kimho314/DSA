package boj;

public class BOJ25214 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;
    static int[] SUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int min = A[0];
        int max = A[0];
        SUMS[0] = 0;
        for (int i = 1; i < N; i++) {
            if (max <= A[i]) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i]);
                int diff = max - min;
                int maxSum = Math.max(SUMS[i - 1], diff);
                SUMS[i] = maxSum;
            }
            else {
                min = Math.min(min, A[i]);
                max = A[i];
                SUMS[i] = SUMS[i - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(SUMS[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        SUMS = new int[N];
    }
}
