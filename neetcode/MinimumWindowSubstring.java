package neetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("a", "a"));
        System.out.println(sol.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        if (s.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int have = 0;
        int need = mapT.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            mapS.put(rightChar, mapS.getOrDefault(rightChar, 0) + 1);

            if (mapT.containsKey(rightChar) && mapS.get(rightChar).equals(mapT.get(rightChar))) {
                have++;
            }

            while (need == have) {
                if ((r - l + 1) < resLen) {
                    resLen = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                mapS.put(leftChar, mapS.get(leftChar) - 1);
                if (mapT.containsKey(leftChar) && mapS.get(leftChar) < mapT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        if (resLen == Integer.MAX_VALUE) {
            return "";
        }
        else {
            return s.substring(res[0], res[1] + 1);
        }
    }
}
