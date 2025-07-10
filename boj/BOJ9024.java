package boj;

import java.util.*;

public class BOJ9024 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        T = SC.nextInt();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            int k = SC.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = SC.nextInt();
            }

            int cnt = search(n, k, nums);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    // 10 8
    // -7 9 2 -4 12 1 5 -3 -2 0
    // -7 -4 -3 -2 0 1 2 5 9 12
    private static int search(int n, int k, int[] arr) {
        Arrays.sort(arr);

        int cnt = 0;
        int l = 0;
        int r = n - 1;
        int res = 200_000_000;
        while (l < r) {
            int sum = arr[l] + arr[r];
            int dist = Math.abs(sum - k);
            // System.out.println(l + " " + r + " " + sum + " " + dist + " " + cnt + " " + res);
            if (res > dist) {
                res = dist;
                cnt = 1;
            } else if (res == dist) {
                cnt++;
            }

            if (sum <= k) {
                l++;
            } else {
                r--;
            }
        }

        return cnt;
    }
}
