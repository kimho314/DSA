package boj;

import java.util.HashSet;

public class BOJ1268 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] S;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int maxStudent = 0;
        int maxCnt = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < N; k++) {
                    if (i == k) {
                        continue;
                    }
                    if (set.contains(k)) {
                        continue;
                    }

                    if (S[i][j] == S[k][j]) {
                        set.add(k);
                    }
                }
            }
//            System.out.println((i + 1) + " " + set.size() + " " + maxCnt);
            if (set.size() > maxCnt) {
                maxCnt = set.size();
                maxStudent = i;
            }
        }

        System.out.println(maxStudent + 1);
    }

    private static void input() {
        N = SC.nextInt();
        S = new int[N][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                S[i][j] = SC.nextInt();
            }
        }
    }
}
