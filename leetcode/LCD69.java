package leetcode;

public class LCD69 {
    public static void main(String[] args) {
        LCD69 sol = new LCD69();
        System.out.println(sol.mySqrt(4));
        System.out.println(sol.mySqrt(8));
        System.out.println(sol.mySqrt(2147395600));
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1, right = x / 2 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long val = (long) mid * mid;
            if (val <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}
