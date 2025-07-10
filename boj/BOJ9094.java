package boj;

public class BOJ9094 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static int[] N, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int cnt = 0; cnt < T; cnt++) {
            int res = 0;
            for (int i = 1; i < N[cnt] - 1; i++) {
                for (int j = i + 1; j < N[cnt]; j++) {
                    double x = ((double) (i * i) + (double) (j * j) + (double) M[cnt]) / ((double) i * (double) j);
//                    System.out.println(i + " " + j + " " + x + " " + (int) x);
                    if (x - (int) x == 0.0) {
                        res++;
                    }
                }
            }
            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
        N = new int[T];
        M = new int[T];
        for (int i = 0; i < T; i++) {
            int n = SC.nextInt();
            int m = SC.nextInt();
            N[i] = n;
            M[i] = m;
        }
    }
}
