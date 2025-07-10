package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ1269 {
    static FastReader SC = new FastReader();
    static int NUM_A, NUM_B;
    static Map<Integer, Integer> A, B;

    public static void main(String[] args) {
        NUM_A = SC.nextInt();
        NUM_B = SC.nextInt();
        A = new HashMap<>();
        B = new HashMap<>();
        for (int i = 0; i < NUM_A; i++) {
            int num = SC.nextInt();
            A.put(num, A.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < NUM_B; i++) {
            int num = SC.nextInt();
            B.put(num, B.getOrDefault(num, 0) + 1);
        }

        int cnt1 = 0;
        for (Integer key : A.keySet()) {
            if (!B.containsKey(key)) {
                cnt1++;
            }
        }

        int cnt2 = 0;
        for (Integer key : B.keySet()) {
            if (!A.containsKey(key)) {
                cnt2++;
            }
        }

        System.out.println(cnt1 + cnt2);
    }

}
