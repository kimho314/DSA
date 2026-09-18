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

        int min = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int l = 0;
        int have = 0;
        int need = mapT.size();

        for (int r = 0; r < s.length(); r++) {
            char elemR = s.charAt(r);
            mapS.put(elemR, mapS.getOrDefault(elemR, 0) + 1);

            if (mapT.containsKey(elemR) && mapT.get(elemR).equals(mapS.get(elemR))) {
                have++;
            }

            while (need == have) {
                if (min > (r - l + 1)) {
                    min = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }

                char elemL = s.charAt(l);
                mapS.put(elemL, mapS.get(elemL) - 1);
                if (mapT.containsKey(elemL) && mapT.get(elemL) > mapS.get(elemL)) {
                    have--;
                }
                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
