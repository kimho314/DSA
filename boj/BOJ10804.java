package boj;

public class BOJ10804 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        for (int i = 0; i < 10; i++) {
            int a = SC.nextInt();
            int b = SC.nextInt();
            solve(a, b);
//            System.out.println(Arrays.toString(Arrays.copyOfRange(NUMS, 1, NUMS.length)));
        }

        for (int i = 1; i <= 20; i++) {
            System.out.print(NUMS[i] + " ");
        }
    }

    private static void solve(int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            int tmp = NUMS[end - i];
            NUMS[end - i] = NUMS[start + i];
            NUMS[start + i] = tmp;
        }
    }

    private static void input() {
        NUMS = new int[21];
        for (int i = 1; i <= 20; i++) {
            NUMS[i] = i;
        }
    }
}
