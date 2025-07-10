package leetcode;

public class LCD326 {
    public static void main(String[] args) {
        LCD326 sol = new LCD326();
        System.out.println(sol.isPowerOfThree(27));
        System.out.println(sol.isPowerOfThree(0));
        System.out.println(sol.isPowerOfThree(-1));
        System.out.println(sol.isPowerOfThree(1));
        System.out.println(sol.isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;

        if (n == 1)
            return true;

        if (n % 3 != 0)
            return false;

        return isPowerOfThree(n / 3);
    }
}
