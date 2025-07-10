package boj;

import java.util.*;
import java.util.Comparator.*;

public class BOJ20291 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static String[] ARR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : ARR) {
            String[] split = s.split("\\.");
            // System.out.println(Arrays.toString(split));
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.comparing(it -> String.valueOf(it)));
        for (String s : list) {
            System.out.println(s + " " + map.get(s));
        }
    }

    private static void input() {
        N = SC.nextInt();
        ARR = new String[N];
        for (int i = 0; i < N; i++) {
            ARR[i] = SC.nextLine();
        }
    }
}
