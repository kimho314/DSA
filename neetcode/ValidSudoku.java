

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();
        /*
         * Input: board = [["1","2",".",".","3",".",".",".","."],
         * ["4",".",".","5",".",".",".",".","."], [".","9","8",".",".",".",".",".","3"],
         * ["5",".",".",".","6",".",".",".","4"], [".",".",".","8",".","3",".",".","5"],
         * ["7",".",".",".","2",".",".",".","6"], [".",".",".",".",".",".","2",".","."],
         * [".",".",".","4","1","9",".",".","8"], [".",".",".",".","8",".",".","7","9"]]
         * 
         * Output: true
         * 
         */
        /**
         * Input: board = [["1","2",".",".","3",".",".",".","."],
         * ["4",".",".","5",".",".",".",".","."], [".","9","1",".",".",".",".",".","3"],
         * ["5",".",".",".","6",".",".",".","4"], [".",".",".","8",".","3",".",".","5"],
         * ["7",".",".",".","2",".",".",".","6"], [".",".",".",".",".",".","2",".","."],
         * [".",".",".","4","1","9",".",".","8"], [".",".",".",".","8",".",".","7","9"]]
         * 
         * Output: false
         */
    }

    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean flag1 = checkRow(i, j, board);
                if (!flag1) {
                    System.out.println("1" + " " + i + " " + j);
                    return false;
                }

                boolean flag2 = checkCol(i, j, board);
                if (!flag2) {
                    System.out.println("2" + " " + i + " " + j);
                    return false;
                }
            }
        }

        for (int i = 0; i < r; i += 3) {
            for (int j = 0; j < c; j += 3) {
                boolean flag3 = checkBox(i, j, board);
                if (!flag3) {
                    System.out.println("3" + " " + i + " " + j);
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkBox(int r, int c, char[][] board) {
        HashSet<Character> set = new HashSet<>();

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
            }
        }

        return true;
    }

    private boolean checkCol(int r, int c, char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < board[0].length; i++) {
            char num = board[r][i];
            if (num == '.') {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }

        return true;
    }

    private boolean checkRow(int r, int c, char[][] board) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            char num = board[i][c];
            if (num == '.') {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }
}
