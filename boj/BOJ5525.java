package boj;

public class BOJ5525 {
    static FastReader SC = new FastReader();
    static int N, M;
    static String INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int ans = 0;
        int idx = 0;
        int cnt = 0;

        while (idx < M - 1) {
            if (INPUT.substring(idx, Math.min(idx + 3, M)).equals("IOI")) {
                idx += 2;
                cnt++;
                if (cnt == N) {
                    ans++;
                    cnt--;
                }
            }
            else {
                idx++;
                cnt = 0;
            }
        }

        System.out.println(ans);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        INPUT = SC.nextLine();
    }
}
