package boj;

import java.util.*;

public class BOJ2960 {
    private static FastReader SC = new FastReader();
    private static int N, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
    }

    private static void solve() {
        boolean[] nums = new boolean[1001];
        int cnt = 0;
        int res = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (nums[j]) {
                    continue;
                }

                nums[j] = true;
                cnt++;
                if (cnt == K) {
                    res = j;
                    break;
                }
            }
        }

        System.out.println(res);
    }

}
