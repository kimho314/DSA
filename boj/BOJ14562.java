package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ14562 {
    private static FastReader SC = new FastReader();
    private static int C;
    private static int[] S, T;
    private static StringBuilder SB = new StringBuilder();
    private static int CNT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < C; i++) {
            int s = S[i];
            int t = T[i];
            CNT = 0;
            bfs(s, t);
            SB.append(CNT).append('\n');
        }

        System.out.println(SB);
    }

    private static void bfs(int startS, int startT) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startS);
        q.add(startT);
        q.add(0);

        while (!q.isEmpty()) {
            int s = q.poll();
            int t = q.poll();
            int cnt = q.poll();
            if (s == t) {
                CNT = cnt;
                return;
            }
            if (s > t) {
                continue;
            }
            int ds = s + s;
            int dt = t + 3;
            q.add(ds);
            q.add(dt);
            q.add(cnt + 1);

            ds = s + 1;
            dt = t;
            q.add(ds);
            q.add(dt);
            q.add(cnt + 1);
        }
    }

    private static void input() {
        C = SC.nextInt();
        S = new int[C];
        T = new int[C];
        for (int i = 0; i < C; i++) {
            S[i] = SC.nextInt();
            T[i] = SC.nextInt();
        }
    }
}
