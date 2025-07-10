package leetcode;

public class LCD392 {
    public static void main(String[] args) {
        LCD392 sol = new LCD392();
        System.out.println(sol.isSubsequence("abc", "ahbgdc"));
        System.out.println(sol.isSubsequence("axc", "ahbgdc"));
        System.out.println(sol.isSubsequence("", "ahbgdc"));
        System.out.println(sol.isSubsequence("", ""));
        System.out.println(sol.isSubsequence("axc", ""));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
