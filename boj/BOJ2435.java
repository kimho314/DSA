package boj;

public class BOJ2435 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N - K + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += A[j];
            }
//            System.out.println(sum);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
//        System.out.println();
        System.out.println(maxSum);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
