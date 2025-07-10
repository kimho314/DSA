package boj;

import java.util.Arrays;

public class BOJ2891 {
    static FastReader SC = new FastReader();
    static int N, S, R;
    static int[] PLAYERS;
    static int[] NO_KAYAK;
    static int[] EXTRA_KAYAK;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.fill(PLAYERS, 1);

        for (int i = 0; i < S; i++) {
            PLAYERS[NO_KAYAK[i]]--;
        }
        for (int i = 0; i < R; i++) {
            PLAYERS[EXTRA_KAYAK[i]]++;
        }

        for (int i = 1; i < N; i++) {
            if (PLAYERS[i] == 0 && PLAYERS[i + 1] == 2) {
                PLAYERS[i]++;
                PLAYERS[i + 1]--;
                continue;
            }
            if (PLAYERS[i] == 2 && PLAYERS[i + 1] == 0) {
                PLAYERS[i + 1]++;
                PLAYERS[i]--;
            }
        }

        int cnt = 0;
        for (int player : PLAYERS) {
            if (player == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        S = SC.nextInt();
        R = SC.nextInt();
        PLAYERS = new int[N + 1];
        NO_KAYAK = new int[S];
        EXTRA_KAYAK = new int[R];
        for (int i = 0; i < S; i++) {
            NO_KAYAK[i] = SC.nextInt();
        }
        for (int i = 0; i < R; i++) {
            EXTRA_KAYAK[i] = SC.nextInt();
        }
    }
}
