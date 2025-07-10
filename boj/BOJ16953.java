package boj;

import java.util.*;

public class BOJ16953 {
    private static FastReader SC = new FastReader();
    private static int A, B;


    public static void main(String[] args) {
        input();
        solve();
        // solve2();
    }

    private static void solve2() {
        int answer = 1;
        int current = B;
        while (current != A) {
            if (current % 10 == 1) {
                current /= 10;
            } else if (current % 2 == 0) {
                current /= 2;
            } else {
                answer = -1;
                break;
            }

            if (current < A) {
                answer = -1;
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
    }

    private static void solve() {
        long res = bfs(A);
        System.out.println(res);
    }

    private static long bfs(int start) {
        Queue<Long> q = new LinkedList<>();
        q.add((long) start);
        q.add(1L);

        while (!q.isEmpty()) {
            long n = q.poll();
            long d = q.poll();
            // System.out.println(n + " " + d);
            if (n == B) {
                return d;
            }

            long dn = n * 2;
            long dd = d + 1;
            if (dn > 0 && dn <= B) {
                q.add(dn);
                q.add(dd);

            }
            dn = (n * 10) + 1;
            dd = d + 1;
            if (dn > 0 && dn <= B) {
                q.add(dn);
                q.add(dd);
            }
        }

        return -1;
    }
}
