package boj;

import java.util.Arrays;

public class BOJ5054 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;

            int n = SC.nextInt();
            int[] stores = new int[n];
            for (int i = 0; i < n; i++) {
                stores[i] = SC.nextInt();
            }
            int dist = solve(n, stores);
            sb.append(dist).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int solve(int n, int[] stores) {
        Arrays.sort(stores);
        int dist = 0;
        int prev = stores[0];
        for (int i = 1; i < n; i++) {
            dist += Math.abs(stores[i] - prev);
            prev = stores[i];
        }
        dist += Math.abs(stores[n - 1] - stores[0]);

        return dist;
    }

    private static void input() {
        T = SC.nextInt();
    }
}
