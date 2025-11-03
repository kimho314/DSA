import java.util.*;

public class WordSearch {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private boolean isExist;

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        boolean res = sol.exist(
                new char[][] {{'A', 'B', 'C', 'D'}, {'S', 'A', 'A', 'T'}, {'A', 'C', 'A', 'E'}},
                "CAT");
        System.out.println(res);
        res = sol.exist(
                new char[][] {{'A', 'B', 'C', 'D'}, {'S', 'A', 'A', 'T'}, {'A', 'C', 'A', 'E'}},
                "BAT");
        System.out.println(res);
    }

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        isExist = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited = new boolean[r][c];
                visited[i][j] = true;
                dfs(board, r, c, i, j, word, String.valueOf(board[i][j]));
                if (isExist) {
                    break;
                }
            }
        }


        return isExist;
    }

    private void dfs(char[][] board, int r, int c, int y, int x, String target, String str) {
        // System.out.println(y + " " + x + " " + str);
        if (str.equals(target)) {
            isExist = true;
            return;
        }
        if (y >= r || x >= c || y < 0 || x < 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];

            if (dy >= r || dx >= c || dy < 0 || dx < 0) {
                continue;
            }
            if (visited[dy][dx]) {
                continue;
            }

            String s = String.valueOf(board[dy][dx]);
            visited[dy][dx] = true;
            dfs(board, r, c, dy, dx, target, str + s);
            visited[dy][dx] = false;
        }
    }
}
