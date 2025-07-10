package boj;

import java.util.Arrays;
import java.util.TreeSet;

public class BOJ19699 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] H;
    private static TreeSet<Integer> SUMS = new TreeSet<>();
    private static int[] SELECTED;
    private static boolean[] VISITED;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(H);

        recFunc(0, -1, 0);

        if (SUMS.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Integer sum : SUMS) {
                System.out.print(sum + " ");
            }
        }
    }

    private static void recFunc(int k, int prevIdx, int sum) {
        if (k == M) {
            System.out.println(sum + " " + Arrays.toString(Arrays.copyOfRange(SELECTED, 0, M)));
            boolean isPrime = isPrime(sum);
            if (isPrime) {
                SUMS.add(sum);
            }
        } else {
            for (int i = prevIdx + 1; i < N; i++) {
                if (VISITED[i]) {
                    continue;
                }
                VISITED[i] = true;
                SELECTED[k] = H[i];
                recFunc(k + 1, i, sum + H[i]);
                SELECTED[k] = 0;
                VISITED[i] = false;
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = SC.nextInt();
        }
        VISITED = new boolean[N];
        SELECTED = new int[N];
    }
}
