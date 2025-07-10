package boj;

public class BOJ1547 {
    private static FastReader SC = new FastReader();
    private static int M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] cups = new int[4];
        for (int i = 1; i < 4; i++) {
            cups[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();

            int tmp = cups[y];
            cups[y] = cups[x];
            cups[x] = tmp;
        }

        int res = -1;
        for (int i = 1; i <= 3; i++) {
            if (cups[i] == 1) {
                res = i;
            }
        }
        System.out.println(res);
    }

    private static void input() {
        M = SC.nextInt();
    }
}
