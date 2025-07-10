package boj;

import java.util.*;

public class BOJ1969 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static String[] DNA;

    public static void main(String[] args) {
        input();
        solve();
    }


    private static void solve() {
        int dist = 0;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < M; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                char ch = DNA[j].charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            ArrayList<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            char ch = ' ';
            int cnt = 0;
            for (char elem : list) {
                if (cnt < map.get(elem)) {
                    cnt = map.get(elem);
                    ch = elem;
                }
            }

            sb.append(ch);
            dist += (N - cnt);
        }

        System.out.println(sb);
        System.out.println(dist);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        DNA = new String[N];
        for (int i = 0; i < N; i++) {
            DNA[i] = SC.nextLine();
        }
    }
}
