package neetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();
        List<String> res = sol.generateParenthesis(1);
        IO.println(res);
        res = sol.generateParenthesis(3);
        IO.println(res);
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, n, res, sb);
        return res;
    }

    private void dfs(int openN, int closedN, int n, List<String> res, StringBuilder sb) {
        if (openN == closedN && closedN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append('(');
            dfs(openN + 1, closedN, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closedN < openN) {
            sb.append(')');
            dfs(openN, closedN + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
