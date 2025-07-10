package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ10808 {
    static FastReader SC = new FastReader();
    static Map<Character, Integer> MAP = new HashMap<>();

    public static void main(String[] args) {
        String str = SC.nextLine();

        for (int i = 'a'; i <= 'z'; i++) {
            MAP.put((char) i, 0);
        }

        for (int i = 0; i < str.length(); i++) {
            MAP.put(str.charAt(i), MAP.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (Integer elem : MAP.values()) {
            System.out.print(elem + " ");
        }
    }
}
