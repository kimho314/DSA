package boj;

import java.util.*;

public class BOJ1758 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayList<Integer> M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Collections.sort(M, Comparator.reverseOrder());

        long res = 0;
        for (int i = 0; i < N; i++) {
            long money = M.get(i) - i;
            if (money < 0) {
                money = 0;
            }
            res += money;
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            M.add(SC.nextInt());
        }
    }
}
