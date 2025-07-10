package boj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ17269 {
    static FastReader SC = new FastReader();
    static Map<String, Integer> MAP = new HashMap<>();
    static int N, M;
    static String[] A, B;

    public static void main(String[] args) {
        init();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Math.min(N, M); i++) {
            list.add(MAP.get(A[i]));
            list.add(MAP.get(B[i]));
        }
        if (N > M) {
            for (int i = M; i < N; i++) {
                list.add(MAP.get(A[i]));
            }
        }
        if (N < M) {
            for (int i = N; i < M; i++) {
                list.add(MAP.get(B[i]));
            }
        }

        while (list.size() > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list = temp;
        }

        System.out.println(Integer.parseInt(list.get(0) + "" + list.get(1)) + "%");
    }

    private static void init() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new String[N];
        B = new String[M];
        String next1 = SC.next();
        for (int i = 0; i < N; i++) {
            A[i] = String.valueOf(next1.charAt(i));
        }
        String next2 = SC.next();
        for (int i = 0; i < M; i++) {
            B[i] = String.valueOf(next2.charAt(i));
        }

        MAP.put("A", 3);
        MAP.put("B", 2);
        MAP.put("C", 1);
        MAP.put("D", 2);
        MAP.put("E", 4);
        MAP.put("F", 3);
        MAP.put("G", 1);
        MAP.put("H", 3);
        MAP.put("I", 1);
        MAP.put("J", 1);
        MAP.put("K", 3);
        MAP.put("L", 1);
        MAP.put("M", 3);
        MAP.put("N", 2);
        MAP.put("O", 1);
        MAP.put("P", 2);
        MAP.put("Q", 2);
        MAP.put("R", 2);
        MAP.put("S", 1);
        MAP.put("T", 2);
        MAP.put("U", 1);
        MAP.put("V", 1);
        MAP.put("W", 1);
        MAP.put("X", 2);
        MAP.put("Y", 2);
        MAP.put("Z", 1);
    }
}
