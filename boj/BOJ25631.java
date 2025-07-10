package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BOJ25631 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(A[i]);
        }

        HashSet<Integer> set = new HashSet<>(list);
        List<Integer> list2 = new ArrayList<>(set);

        int maxCnt = 0;
        for (Integer num : list2) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (num == A[i]) {
                    cnt++;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
