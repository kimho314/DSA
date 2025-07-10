package boj;

public class BOJ14246 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long res = 0;

        long totalSum = 0;
        for (int i = 0; i < N; i++) {
            totalSum += A[i];
        }

        for (int i = 0; i < N; i++) {
            totalSum -= (i == 0 ? 0 : A[i - 1]);
            long sum = totalSum;
            for (int j = N - 1; j >= i; j--) {
                sum -= (j == N - 1 ? 0 : A[j + 1]);
//                System.out.println(i + " " + j + " " + A[i] + " " + A[j] + " " + sum);
                if (sum <= K) {
                    break;
                }
                res++;
            }
        }

        System.out.println(res);
    }


    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        K = SC.nextInt();
    }
}
