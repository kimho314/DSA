

import java.util.*;

public class LongestRepeatingCharacterReplacementSolved {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacementSolved sol =
                new LongestRepeatingCharacterReplacementSolved();
        IO.println(sol.characterReplacement("XYYX", 2)); // 4
        IO.println(sol.characterReplacement("AAABABB", 1)); // 5
        IO.println(sol.characterReplacement(
                "BRJRRKNRBFOOKDEEGODTGMHNABMTHFNPTFRHRSEKKTFEQIKSIAJJMSDSLNSCNRNJFNFSIQDNMHDRIJIACLCJKATTFHDASGLRQSFN",
                10)); // 15
    }

    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxf = 0;
        int l = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while ((r - l + 1 - maxf) > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, (r - l + 1));
        }

        return res;
    }

    public int characterReplacement2(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, map.get(s.charAt(j)));
                if ((j - i + 1) - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
