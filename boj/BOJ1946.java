package boj;

public class BOJ1946 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();

        while (T > 0) {
            T--;
            solve();
        }

        System.out.println(SB);
    }


    private static void solve() {
        int n = SC.nextInt();

        int res = 1;
        int[] work = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = SC.nextInt();
            int b = SC.nextInt();
            work[a] = b;
        }

        int vot = work[1];
        for (int i = 2; i <= n; i++) {
            if (work[i] < vot) {
                vot = work[i];
                res++;
            }
        }

        SB.append(res).append('\n');
    }

    private static void input() {
        T = SC.nextInt();
    }
}
