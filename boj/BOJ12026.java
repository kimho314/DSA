package boj;

import java.util.Arrays;

public class BOJ12026 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[] BLOCKS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] prev = new int[N];
        Arrays.fill(prev, -1);
        prev[0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (isJump(j, i) && dp[j] < Integer.MAX_VALUE) {
                    prev[i] = j;
                    int energy = (i - j) * (i - j);
                    dp[i] = Math.min(dp[i], energy + dp[j]);
                }
            }
        }

        boolean isPossible = true;
        int idx = N - 1;
        while (true) {
            if (prev[idx] == -1) {
                isPossible = false;
                break;
            }
            if (prev[idx] == 0) {
                break;
            }

            idx = prev[idx];
        }

        if (!isPossible) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }

    private static boolean isJump(int from, int to) {
        if (BLOCKS[to] == 'B' && BLOCKS[from] == 'J') {
            return true;
        } else if (BLOCKS[to] == 'O' && BLOCKS[from] == 'B') {
            return true;
        } else if (BLOCKS[to] == 'J' && BLOCKS[from] == 'O') {
            return true;
        } else {
            return false;
        }
    }

    private static void input() {
        N = SC.nextInt();
        BLOCKS = SC.next().toCharArray();
    }
}
