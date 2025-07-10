package boj;

public class BOJ1455 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (MAP[i][j] == 1) {
                    res++;
                    for (int k1 = 0; k1 <= i; k1++) {
                        for (int k2 = 0; k2 <= j; k2++) {
                            if (MAP[k1][k2] == 1) {
                                MAP[k1][k2] = 0;
                            } else {
                                MAP[k1][k2] = 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }
    }
}
