package boj;

import java.util.*;

public class BOJ21939 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static HashMap<Integer, Integer> MAP = new HashMap<>();


    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            int p = SC.nextInt();
            int l = SC.nextInt();
            MAP.put(p, l);
        }
        M = SC.nextInt();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> {
            int comp = Integer.compare(MAP.get(o1), MAP.get(o2));
            if (comp != 0) {
                return comp;
            }
            return Integer.compare(o1, o2);
        });
        for (Integer elem : MAP.keySet()) {
            set.add(elem);
        }

        while (M > 0) {
            M--;
            String op = SC.next();
            switch (op) {
                case "add":
                    int p = SC.nextInt();
                    int l = SC.nextInt();
                    MAP.put(p, l);
                    set.add(p);
                    break;
                case "recommend":
                    int x = SC.nextInt();
                    if (x == 1) {
                        int n = set.last();
                        sb.append(n).append("\n");
                    } else {
                        int n = set.first();
                        sb.append(n).append("\n");
                    }
                    break;
                case "solved":
                    p = SC.nextInt();
                    set.remove(p);
                    MAP.remove(p);
                    break;
            }
        }

        System.out.println(sb);
    }
}
