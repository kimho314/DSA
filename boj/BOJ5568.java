package boj;

import java.util.*;

public class BOJ5568 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] A, CNT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        HashSet<Integer> set = new HashSet<>();

        recFunc("", 0, set);

        System.out.println(set.size());
    }

    private static void recFunc(String str, int cnt, HashSet<Integer> set) {
        if (cnt == K) {
            int num = Integer.parseInt(str);
            // System.out.println(num);
            set.add(num);
        } else {
            for (int i = 0; i < N; i++) {
                if (CNT[A[i]] > 0) {
                    CNT[A[i]]--;
                    recFunc(str + A[i], cnt + 1, set);
                    CNT[A[i]]++;
                }
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        A = new int[N];
        CNT = new int[100];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
            CNT[A[i]]++;
        }
    }
}
