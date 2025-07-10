package boj;

public class BOJ19637 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static String[] NAMES;
    private static int[] LEVELS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (M > 0) {
            M--;
            int in = SC.nextInt();

            int l = 0;
            int r = N - 1;
            int res = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (LEVELS[mid] >= in) {
                    r = mid - 1;
                    res = mid;
                } else {
                    l = mid + 1;
                }
            }

            sb.append(NAMES[res]).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        NAMES = new String[N];
        LEVELS = new int[N];
        for (int i = 0; i < N; i++) {
            String s = SC.next();
            int l = SC.nextInt();
            NAMES[i] = s;
            LEVELS[i] = l;
        }
    }
}
