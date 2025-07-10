package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ3059 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        while (T > 0) {
            T--;
            char[] arr = SC.nextLine().toCharArray();
            solve(arr);
        }

        System.out.println(SB.toString());
    }

    private static void solve(char[] arr) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put((char) i, 0);
        }

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        int sum = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                sum += (int) entry.getKey();
            }
        }
        SB.append(sum).append("\n");
    }

    private static void input() {
        T = SC.nextInt();
    }
}
