

public class Searcha2DMatrix {
    public static void main(String[] args) {
        Searcha2DMatrix sol = new Searcha2DMatrix();
        System.out.println(sol
                .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(sol
                .searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int len = n * m;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = matrix[i / m][i % m];
        }

        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int len = n * m;

        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid / m][mid % m] == target) {
                return true;
            } else if (matrix[mid / m][mid % m] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
