package boj;

import java.util.*;

public class BOJ10815 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] CARDS;
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(CARDS);

        int[] res = new int[M];
        for (int i = 0; i < M; i++) {
            int l = 0;
            int r = N - 1;
            if (CARDS[l] == NUMS[i] || CARDS[r] == NUMS[i]) {
                res[i] = 1;
                continue;
            }
            while (l <= r) {
                int mid = (l + r) / 2;
                if (CARDS[mid] == NUMS[i]) {
                    res[i] = 1;
                    break;
                } else if (CARDS[mid] < NUMS[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        CARDS = new int[N];
        for (int i = 0; i < N; i++) {
            CARDS[i] = SC.nextInt();
        }
        M = SC.nextInt();
        NUMS = new int[M];
        for (int i = 0; i < M; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
