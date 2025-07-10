package boj;

public class BOJ11060 {
    static FastReader SC = new FastReader();
    static int[] A;
    static int N;
    static int[] DP;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N + 1];
        DP = new int[1101];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
            DP[i] = Integer.MAX_VALUE;
        }

        DP[1] = 0;
        for (int i = 1; i <= N; i++) {
            if (DP[i] >= Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= A[i]; j++) {
                DP[i + j] = Math.min(DP[i + j], DP[i] + 1);
            }
        }

        if (DP[N] >= Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(DP[N]);
        }
    }
}
