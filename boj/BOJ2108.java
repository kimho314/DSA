package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class BOJ2108 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayList<Integer> NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = NUMS.stream().mapToInt(i -> i).sum();
        double factor = sum >= 0 ? 0.5 : -0.5;
        int avg = (int) ((double) sum / (double) N + factor);

        Collections.sort(NUMS);

        int medium = NUMS.get(NUMS.size() / 2);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        NUMS.forEach(it -> map.put(it, map.getOrDefault(it, 0) + 1));
        int frequent = NUMS.get(0);
        for (int i = 1; i < NUMS.size(); i++) {
            if (map.get(frequent) < map.get(NUMS.get(i))) {
                frequent = NUMS.get(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int cmp = map.get(frequent);
        map.forEach((k, v) -> {
            if (v == cmp) {
                list.add(k);
            }
        });
        Collections.sort(list);
        if (list.size() >= 2) {
            frequent = list.get(1);
        }

        int diff = NUMS.get(NUMS.size() - 1) - NUMS.get(0);

        System.out.println(avg);
        System.out.println(medium);
        System.out.println(frequent);
        System.out.println(diff);
    }

    private static void input() {
        N = SC.nextInt();
        NUMS = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            NUMS.add(SC.nextInt());
        }
    }
}
