import java.util.*;

public class SurroundedRegions {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public static void main(String[] args) {
        SurroundedRegions sol = new SurroundedRegions();
        char[][] board = new char[][] {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'O'}};
        sol.solve(board);
        print(board);
    }

    private static void print(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board);
            }
            if (board[i][col - 1] == 'O') {
                bfs(i, col - 1, board);
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                bfs(0, i, board);
            }
            if (board[row - 1][i] == 'O') {
                bfs(row - 1, i, board);
            }
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int startY, int startX, char[][] map) {
        visited[startY][startX] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(startY);
        q.add(startX);

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = y + dir[i][0];
                int dx = x + dir[i][1];

                if (dy < 0 || dx < 0 || dy >= map.length || dx >= map[0].length) {
                    continue;
                }
                if (visited[dy][dx] || map[dy][dx] == 'X') {
                    continue;
                }

                visited[dy][dx] = true;
                q.add(dy);
                q.add(dx);
            }
        }
    }
}
