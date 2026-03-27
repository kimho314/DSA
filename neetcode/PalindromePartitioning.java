import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public static void main(String[] args) {
        PalindromePartitioning sol = new PalindromePartitioning();
        System.out.println(sol.partition("aab"));
        System.out.println(sol.partition("a"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, part, res);

        return res;
    }

    private void dfs(int i, String s, List<String> part, List<List<String>> res) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                part.add(s.substring(i, j + 1));
                dfs(j + 1, s, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
