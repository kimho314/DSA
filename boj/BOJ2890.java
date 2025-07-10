package boj;

import java.util.*;

public class BOJ2890 {
    static FastReader SC = new FastReader();
    static int R, C;
    static Map<Integer, Integer> MAP = new HashMap<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        List<Integer> keySet = new ArrayList<>(MAP.keySet());
        keySet.sort(Comparator.comparing(it -> MAP.get(it)).reversed());

        int rank = 1;
        int prev = MAP.get(keySet.get(0));
        int[] ranks = new int[10];
        for (Integer key : keySet) {
            if (prev != MAP.get(key)) {
                rank++;
            }
            ranks[key] = rank;
            prev = MAP.get(key);
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(ranks[i]);
        }
    }

    private static void input() {
        R = SC.nextInt();
        C = SC.nextInt();

        for (int i = 0; i < R; i++) {
            String str = SC.nextLine();
            int idx = -1;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) >= '1' && str.charAt(j) <= '9') {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) {
                continue;
            }

            MAP.put(Integer.parseInt(String.valueOf(str.charAt(idx))), idx);
        }
    }
}
