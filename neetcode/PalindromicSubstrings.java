public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings sol = new PalindromicSubstrings();
        int res = sol.countSubstrings("abc");
        System.out.println(res); // 3
        res = sol.countSubstrings("aaa");
        System.out.println(res); // 6
        res = sol.countSubstrings("a");
        System.out.println(res); // 1
    }

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int cnt = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
