package boj;

public class BOJ25400 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int idx = 1;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (idx != A[i]) {
                cnt++;
            }
            else {
                idx++;
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
