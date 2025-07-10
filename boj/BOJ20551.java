package boj;

import java.util.Arrays;
import java.util.HashMap;

public class BOJ20551 {
    static FastReader SC = new FastReader();
    static int[] A, D;
    static int N, M;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(A);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);
            }
        }

        for (int i = 0; i < M; i++) {
            int l = 0;
            int r = N - 1;
            int res = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (A[mid] == D[i]) {
                    res = map.get(A[mid]);
                    break;
                }
                else if (A[mid] < D[i]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            SB.append(res).append('\n');
        }

        System.out.println(SB.toString());
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        D = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        for (int i = 0; i < M; i++) {
            D[i] = SC.nextInt();
        }
    }
}
