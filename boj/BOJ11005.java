package boj;

import java.util.HashMap;

public class BOJ11005 {
    private static FastReader SC = new FastReader();
    private static int N, B;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put(i + 10, String.valueOf((char) ('A' + i)));
        }

        StringBuilder sb = new StringBuilder();

        while (N >= 1) {
            int remainder = N % B;
            if (map.containsKey(remainder)) {
                sb.append(map.get(remainder));
            }
            else {
                sb.append(remainder);
            }

            N /= B;
        }
        sb.reverse();

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        B = SC.nextInt();
    }
}
