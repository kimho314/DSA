package boj;

public class BOJ1904 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] nums = new int[1000001];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= 1000000; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 15746;
        }
        System.out.println(nums[N]);
    }
}
