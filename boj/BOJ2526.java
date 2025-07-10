package boj;

import java.util.LinkedHashSet;

public class BOJ2526 {
    private static FastReader SC = new FastReader();
    private static int N, P;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(N);

        int start = N;
        int num = -1;
        while (true) {
            start = (start * N) % P;
            if (set.contains(start)) {
                num = start;
                break;
            }
            set.add(start);
        }
        int cnt = 0;
        boolean isCycle = false;
        for (int n : set) {
            if (n == num) {
                isCycle = true;
            }
            if (isCycle) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        P = SC.nextInt();
    }
}
