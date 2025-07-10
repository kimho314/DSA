package boj;

import java.util.*;

public class BOJ2503 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] IN;
    private static int CNT = 0;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] nums = new int[10];
        Arrays.fill(nums, 1);
        dfs(0, "", nums);
        System.out.println(CNT);
    }

    private static void dfs(int k, String s, int[] nums) {
        if (k == 3) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int cnt1 = 0;
                int cnt2 = 0;
                String n = String.valueOf(IN[i][0]);
                for (int j = 0; j < 3; j++) {
                    int idx = -1;
                    for (int t = 0; t < 3; t++) {
                        if (n.charAt(j) == s.charAt(t)) {
                            idx = t;
                            break;
                        }
                    }
                    if (idx == -1) {
                        continue;
                    }
                    if (idx == j) {
                        cnt1++;
                    } else {
                        cnt2++;
                    }
                }
                if (cnt1 == IN[i][1] && cnt2 == IN[i][2]) {
                    cnt++;
                }
            }
            if (cnt == N) {
                CNT++;
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (nums[i] == 1) {
                    nums[i]--;
                    dfs(k + 1, s + i + "", nums);
                    nums[i]++;
                }

            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        IN = new int[N][3];
        for (int i = 0; i < N; i++) {
            IN[i][0] = SC.nextInt();
            IN[i][1] = SC.nextInt();
            IN[i][2] = SC.nextInt();
        }
    }
}
