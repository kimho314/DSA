package boj;

import java.util.Arrays;
import java.util.HashSet;

public class BOJ11723 {
    private static FastReader SC = new FastReader();
    private static int M;
    private static HashSet<Integer> ALL_SET = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String op = SC.next();
            switch (op) {
                case "add":
                    int x = SC.nextInt();
                    set.add(x);
                    break;
                case "remove":
                    x = SC.nextInt();
                    set.remove(x);
                    break;
                case "check":
                    x = SC.nextInt();
                    sb.append(set.contains(x) ? "1" : "0").append('\n');
                    break;
                case "toggle":
                    x = SC.nextInt();
                    if (set.contains(x)) {
                        set.remove(x);
                    }
                    else {
                        set.add(x);
                    }
                    break;
                case "all":
                    set.clear();
                    set.addAll(ALL_SET);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }


    private static void input() {
        M = SC.nextInt();
    }
}
