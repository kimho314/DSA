

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
        int len = 0;
        if (s.length() == 0) {
            return len;
        }

        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.get(s.charAt(r)) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            len = Math.max(len, (r - l + 1));
        }

        return len;
    }
}
