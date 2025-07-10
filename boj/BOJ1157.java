package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ1157 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String str = SC.nextLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0);
            map.put(ch, cnt + 1);
        }

        char res = str.charAt(0);
        int max = map.get(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != res) {
                if (max == map.get(str.charAt(i))) {
                    res = '?';
                }
                if (max < map.get(str.charAt(i))) {
                    res = str.charAt(i);
                    max = map.get(str.charAt(i));
                }
            }
        }

        System.out.println(res);
    }
}
