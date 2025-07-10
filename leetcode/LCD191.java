package leetcode;

public class LCD191 {
    public static void main(String[] args) {
        LCD191 sol = new LCD191();
        System.out.println(sol.hammingWeight(11));
        System.out.println(sol.hammingWeight(128));
        System.out.println(sol.hammingWeight(2147483645));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
