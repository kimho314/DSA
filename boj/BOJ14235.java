package boj;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ14235 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        PriorityQueue<Integer> presents = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int a = SC.nextInt();
            if (a == 0) {
                int res = -1;
                if (!presents.isEmpty()) {
                    res = presents.poll();
                }
                sb.append(res).append('\n');
            }
            else {
                for (int j = 0; j < a; j++) {
                    int n = SC.nextInt();
                    presents.add(n);
                }
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
