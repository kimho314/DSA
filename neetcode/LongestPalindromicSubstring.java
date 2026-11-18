package neetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        String res = sol.longestPalindrome("ababd");
        System.out.println(res);
        res = sol.longestPalindrome("abbc");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int resIdx = 0;
        int resLen = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                int tmpLen = j - i + 1;
                if (s.charAt(i) == s.charAt(j) && (tmpLen <= 3 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                    if (resLen < tmpLen) {
                        resLen = tmpLen;
                        resIdx = i;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}
