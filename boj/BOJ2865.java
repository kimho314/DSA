package boj;

import java.util.*;

public class BOJ2865 {
    static FastReader SC = new FastReader();
    static int N, M, K;
    static Map<Integer, List<Double>> MAP = new HashMap<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        MAP.values().forEach(value -> {
            value.sort(Comparator.reverseOrder());
        });

        List<Double> list = new ArrayList<>();
        MAP.forEach((key, value) -> list.add(value.get(0)));
        list.sort(Comparator.reverseOrder());

        double sum = 0.0;
        for (int i = 0; i < K; i++) {
            sum += list.get(i);
        }
        double res = Math.round(sum * 10.0) / 10.0;
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
        for (int cnt1 = 0; cnt1 < M; cnt1++) {
            for (int cnt2 = 0; cnt2 < N; cnt2++) {
                int i = SC.nextInt();
                double s = SC.nextDouble();
                List<Double> list = MAP.getOrDefault(i, new ArrayList<>());
                list.add(s);
                MAP.put(i, list);
            }
        }
    }
}
