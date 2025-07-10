package boj;

import java.util.Arrays;

public class BOJ2776 {
    static FastReader SC = new FastReader();
    static int T;
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            input();
            solve();
        }
    }

    private static void solve() {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < N; i++) {
//            set.add(A[i]);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < M; i++) {
//            boolean isIncluded = set.contains(B[i]);
//            sb.append(isIncluded ? 1 : 0).append('\n');
//        }
//        System.out.print(sb.toString());

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int l = 0;
            int r = N - 1;
            Integer res = null;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (A[mid] == B[i]) {
                    res = A[mid];
                    break;
                }

                if (A[mid] < B[i]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            sb.append(res == null ? 0 : 1).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        M = SC.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = SC.nextInt();
        }
    }
}
