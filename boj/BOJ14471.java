package boj;

import java.util.ArrayList;
import java.util.Collections;

public class BOJ14471 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] A, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = M - 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (A[i] >= N) {
                cnt--;
            } else {
                list.add(A[i]);
            }
        }

        Collections.sort(list);

        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (cnt == 0) {
                break;
            }
            res += N - list.get(i);
            cnt--;
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[M];
        B = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = SC.nextInt();
            B[i] = SC.nextInt();
        }
    }
}
