

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol =
                new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> count = new HashMap<>();
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            while (count.get(s.charAt(r)) > 1) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, (r - l + 1));
        }

        return max;
    }
}
