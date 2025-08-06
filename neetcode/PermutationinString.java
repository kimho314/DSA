package neetcode;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationinString {
    public static void main(String[] args) {
        PermutationinString sol = new PermutationinString();
        System.out.println(sol.checkInclusion("ab", "lecabee"));
        System.out.println(sol.checkInclusion("abc", "lecaabee"));
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String tmp1 = new String(arr1);

        for (int l = 0; l < s2.length(); l++) {

            for (int r = l; r < s2.length(); r++) {
                HashMap<Character, Integer> map2 = new HashMap<>();
                String str = s2.substring(l, r + 1);
                char[] arr2 = str.toCharArray();
                Arrays.sort(arr2);

                String tmp2 = new String(arr2);
                if (tmp1.equals(tmp2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
