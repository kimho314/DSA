package boj;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class BOJ1159 {
    static FastReader SC = new FastReader();
    static int N;
    static String[] PLAYERS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int cnt = map.getOrDefault(String.valueOf(PLAYERS[i].charAt(0)), 0);
            map.put(String.valueOf(PLAYERS[i].charAt(0)), ++cnt);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 5) {
                cnt++;
                sb.append(entry.getKey());
            }
        }

        if (cnt == 0) {
            System.out.println("PREDAJA");
        }
        else {
            System.out.println(sb.toString());
        }
    }

    private static void input() {
        N = SC.nextInt();
        PLAYERS = new String[N];
        for (int i = 0; i < N; i++) {
            PLAYERS[i] = SC.next();
        }
        Arrays.sort(PLAYERS);
    }
}
