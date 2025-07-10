package boj;

import java.util.Arrays;

public class BOJ2110 {
    static FastReader sc = new FastReader();
    static int N, C;
    static int[] HOMES;

    public static void main(String[] args) {
        N = sc.nextInt();
        C = sc.nextInt();
        HOMES = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            HOMES[i] = sc.nextInt();
        }

        Arrays.sort(HOMES, 1, N + 1);
        int l = 0;
        int r = 1000000000;
        int res = 0;

        while (l <= r) {
            int mid = (r + l) / 2;
            if (determination(mid)) {
                l = mid + 1;
                res = mid;
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(res);
    }

    private static boolean determination(int mid) {
        int cnt = 1;
        int cur = 1;
        for (int i = 2; i <= N; i++) {
            if (HOMES[i] - HOMES[cur] >= mid) {
                cnt++;
                cur = i;
            }
        }

        return cnt >= C;
    }

}
