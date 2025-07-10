package boj;

import java.util.*;

public class BOJ1966 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    private static class Paper {
        public int idx;
        public int priority;

        public Paper(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            int n = SC.nextInt();
            int m = SC.nextInt();
            Queue<Paper> papers = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int p = SC.nextInt();
                Paper paper = new Paper(i, p);
                papers.add(paper);
            }
            int res = solve(n, m, papers);
            SB.append(res).append("\n");
        }
        System.out.println(SB);
    }

    private static int solve(int n, int m, Queue<Paper> papers) {
        int res = -1;
        int cnt = 1;
        while (!papers.isEmpty()) {
            Paper paper = papers.poll();
            boolean isAvailable = true;
            for (Paper elem : papers) {
                if (paper.priority < elem.priority) {
                    isAvailable = false;
                    break;
                }
            }
            if (!isAvailable) {
                papers.add(paper);
                continue;
            }
            if (paper.idx == m) {
                res = cnt;
                break;
            }
            cnt++;
        }

        return res;
    }

    private static void input() {
        T = SC.nextInt();
    }
}
