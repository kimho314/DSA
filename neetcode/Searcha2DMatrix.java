

public class Searcha2DMatrix {
    public static void main(String[] args) {
        Searcha2DMatrix sol = new Searcha2DMatrix();
        System.out.println(sol
                .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(sol
                .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;

        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int tmpRow = mid / col;
            int tmpCol = mid % col;
            if (matrix[tmpRow][tmpCol] == target) {
                return true;
            } else if (matrix[tmpRow][tmpCol] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
