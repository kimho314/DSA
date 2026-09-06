package neetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol =
                new LongestRepeatingCharacterReplacement();
        IO.println(sol.characterReplacement("XYYX", 2)); // 4
        IO.println(sol.characterReplacement("AAABABB", 1)); // 5
        IO.println(sol.characterReplacement("AABABB", 1)); // 4
        IO.println(sol.characterReplacement(
                "BRJRRKNRBFOOKDEEGODTGMHNABMTHFNPTFRHRSEKKTFEQIKSIAJJMSDSLNSCNRNJFNFSIQDNMHDRIJIACLCJKATTFHDASGLRQSFN",
                10)); // 15
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int maxf = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            while ((r - l + 1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, (r - l + 1));
        }

        return res;
    }

    public int characterReplacement2(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int res = 0;
        for (char c : set) {
            int count = 0;
            int l = 0;

            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }
                res = Math.max(res, (r - l + 1));
            }
        }
        return res;
    }
}
