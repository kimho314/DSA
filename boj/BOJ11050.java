package boj;

public class BOJ11050 {
    static FastReader SC = new FastReader();
    static int N, K;
    static int[][] DP = new int[11][11];

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();

        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == j || j == 0) {
                    DP[i][j] = 1;
                }
                else {
                    DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
                }
            }
        }
        System.out.println(DP[N][K]);
    }
}
