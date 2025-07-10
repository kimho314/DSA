package boj;

import java.util.LinkedHashMap;

public class BOJ17218 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static LinkedHashMap<String, String> MAP;
    private static String[] TARGETS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String password = MAP.get(TARGETS[i]);
            sb.append(password).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new LinkedHashMap<>();
        TARGETS = new String[M];
        for (int i = 0; i < N; i++) {
            String address = SC.next();
            String password = SC.next();
            MAP.put(address, password);
        }
        for (int i = 0; i < M; i++) {
            TARGETS[i] = SC.next();
        }
    }
}
