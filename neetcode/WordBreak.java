import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        boolean result = sol.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                List.of("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                        "aaaaaaaaaa", "ba"));
        IO.println(result);
        result = sol.wordBreak("neetcode", List.of("neet", "code"));
        IO.println(result);
        result = sol.wordBreak("applepenapple", List.of("apple", "pen", "ape"));
        IO.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if ((i + w.length()) <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
