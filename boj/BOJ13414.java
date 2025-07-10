package boj;

import java.util.HashMap;
import java.util.LinkedList;

public class BOJ13414 {
    private static FastReader SC = new FastReader();
    private static int K, L;
    private static String[] STUDENTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<String> q = new LinkedList<>();

        for (int i = 0; i < L; i++) {
            String id = STUDENTS[i];
            map.put(id, map.getOrDefault(id, 0) + 1);
            q.add(id);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!q.isEmpty()) {
            String id = q.poll();

            if (map.get(id) == 1) {
                sb.append(id).append("\n");
                if (++cnt == K) {
                    break;
                }
            } else {
                map.put(id, map.get(id) - 1);
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        K = SC.nextInt();
        L = SC.nextInt();
        STUDENTS = new String[L];
        for (int i = 0; i < L; i++) {
            STUDENTS[i] = SC.next();
        }
    }
}
