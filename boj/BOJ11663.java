package boj;

import java.util.*;

public class BOJ11663 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            int start = SC.nextInt();
            int end = SC.nextInt();

            int lower = searchUpper(start);
            int upper = searchLower(end);

            int cnt = 0;
            if (lower <= upper) {
                cnt = upper - lower + 1;
            }
            if (start > A[N - 1]) {
                cnt = 0;
            }
            if (end < A[0]) {
                cnt = 0;
            }
            // System.out.println(start + " " + end + " " + lower + " " + upper + " " + cnt);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int searchUpper(int target) {
        int l = 0;
        int r = N - 1;
        int res = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }

    private static int searchLower(int target) {
        int l = 0;
        int r = N - 1;
        int res = N - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] <= target) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
