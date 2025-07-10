package boj;

import java.util.Arrays;

public class BOJ16401 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] L;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        L = new int[M];
        for (int i = 0; i < M; i++) {
            L[i] = SC.nextInt();
        }


        Arrays.sort(L);

        int res = solve();
        System.out.println(res);
    }

    private static int solve() {
        int l = 1;
        int r = L[M - 1];
        int res = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
//            System.out.println("l : " + l + ", r : " + r + ", mid : " + mid);
            if (determination(mid)) {
                l = mid + 1;
                res = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }

    private static boolean determination(int input) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            cnt += (L[i] / input);
        }

        return cnt >= N;
    }
}
