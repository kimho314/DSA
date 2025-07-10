package boj;

import java.util.*;

public class BOJ20207 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] D;

    public static void main(String[] args) {
        input();
        solve();
    }


    private static void solve() {
        int[] days = new int[366];

        Arrays.sort(D, (o1, o2) -> o1[0] - o1[0]);

        for (int i = 0; i < N; i++) {
            int start = D[i][0];
            int end = D[i][1];
            for (int j = start; j <= end; j++) {
                days[j]++;
            }
        }

        // for (int i = 1; i <= 365; i++) {
        // System.out.print(days[i] + " ");
        // }
        // System.out.println();

        int res = 0;
        int len = 0;
        int h = 0;
        int cur = 1;
        while (cur <= 365) {
            if (days[cur] > 0) {
                len++;
                h = Math.max(h, days[cur]);
            } else {
                int area = len * h;
                res += area;
                len = 0;
                h = 0;
            }

            cur++;
        }

        if (len > 0) {
            res += (len * h);
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        D = new int[N][2];
        for (int i = 0; i < N; i++) {
            D[i][0] = SC.nextInt();
            D[i][1] = SC.nextInt();
        }
    }
}
